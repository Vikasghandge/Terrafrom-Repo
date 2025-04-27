pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "ghandgevikas/devopsexamapp:latest"
        SCANNER_HOME = tool 'sonar-scanner'
    }

    stages {
        stage('Git Checkout') {
            steps {
                git url: 'https://github.com/Vikasghandge/Docker.git', 
                    branch: 'main'
            }
        }

        stage('File System Scan') {
            steps {
                sh "trivy fs --scanners vuln,misconfig --format table -o trivy-fs-report.html ."
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar') {
                    sh """
                        ${SCANNER_HOME}/bin/sonar-scanner \
                        -Dsonar.projectName=devops-exam-app \
                        -Dsonar.projectKey=devops-exam-app \
                        -Dsonar.sources=. \
                        -Dsonar.exclusions=**/*.java \
                        -Dsonar.python.version=3 \
                        -Dsonar.host.url=http://localhost:9000
                    """
                }
            }
        }

        stage('Verify Docker Compose') {
            steps {
                sh '''
                    docker compose version || { echo "Docker Compose not available"; exit 1; }
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('devops-exam-app-master/backend') {
                    script {
                        withDockerRegistry(credentialsId: 'docker', toolName: 'docker') {
                            sh "docker build -t ${DOCKER_IMAGE} ."
                            sh "docker push ${DOCKER_IMAGE}"
                        }
                    }
                }
            }
        }

        stage('Docker Scout Image Analysis') {
            steps {
                script {
                    withDockerRegistry(credentialsId: 'docker', toolName: 'docker') {
                        sh "docker-scout quickview ${DOCKER_IMAGE}"
                        sh "docker-scout cves ${DOCKER_IMAGE}"
                        sh "docker-scout recommendations ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Deploy with Docker Compose') {
    steps {
        dir('devops-exam-app-master/backend') {
            sh '''
                #!/bin/bash
                echo "Current working directory:"
                pwd
                echo "Directory contents:"
                ls -la
                
                echo "Stopping any existing containers..."
                docker compose down --remove-orphans || true
                
                echo "Building and starting containers..."
                docker compose up -d --build || { echo "Failed to start containers"; exit 1; }
                
                echo "Waiting for MySQL to be ready..."
                MAX_RETRIES=24
                RETRY_INTERVAL=5
                for i in $(seq 1 $MAX_RETRIES); do
                    if docker compose exec -T mysql mysqladmin ping -uroot -prootpass --silent; then
                        echo "MySQL is ready!"
                        break
                    fi
                    echo "Attempt $i/$MAX_RETRIES: MySQL not ready yet..."
                    docker compose logs mysql --tail=5 || true
                    sleep $RETRY_INTERVAL
                    if [ $i -eq $MAX_RETRIES ]; then
                        echo "ERROR: MySQL failed to start after $MAX_RETRIES attempts"
                        exit 1
                    fi
                done
                
                echo "Verifying services..."
                docker compose ps
                sleep 10
                    '''
                }
            }
        }

        stage('Verify Deployment') {
            steps {
                dir('devops-exam-app-master/backend') {
                    sh '''
                        echo "=== Container Status ==="
                        docker compose ps -a
                        echo "=== Testing Flask Endpoint ==="
                        curl -I http://localhost:5000 || true
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '🚀 Deployment successful!'
            sh 'docker compose ps'
            archiveArtifacts artifacts: 'trivy-fs-report.html', allowEmptyArchive: true
        }
        failure {
            echo '❗ Pipeline failed. Check logs above.'
            sh '''
                echo "=== Error Investigation ==="
                docker compose logs --tail=50 || true
            '''
        }
        always {
            sh '''
                echo "=== Final Logs ==="
                docker compose logs --tail=20 || true
            '''
            archiveArtifacts artifacts: 'trivy-fs-report.html', allowEmptyArchive: true
        }
    }
}