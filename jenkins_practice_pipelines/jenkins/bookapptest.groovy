pipeline {
    agent any
    tools {
        jdk 'jdk17'
        nodejs 'node23'
    }
    stages {
        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }
        stage('Checkout from Git') {
            steps {
                git branch: 'main', url: 'https://github.com/Vikasghandge/Docker.git'
                sh 'ls -la'
            }
        }
        stage('Install Dependencies') {
            steps {
                sh '''
                cd Book-My-Show-main/bookmyshow-app
                ls -la
                if [ -f package.json ]; then
                    rm -rf node_modules package-lock.json
                    npm install
                else
                    echo "Error: package.json not found in bookmyshow-app!"
                    exit 1
                fi
                '''
            }
        }
        stage('OWASP FS Scan') {
            steps {
                dependencyCheck additionalArguments: '--scan ./ --disableYarnAudit --disableNodeAudit', odcInstallation: 'DP-Check'
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
        stage('Trivy FS Scan') {
            steps {
                sh 'trivy fs . > trivyfs.txt'
            }
        }
         stage('Docker Build & Push') {
            steps {
                dir('Book-My-Show-main') {
                    script {
                        withDockerRegistry(credentialsId: 'docker', toolName: 'docker') {
                            sh ''' 
                            echo "Building Docker image..."
                            docker build --no-cache -t ghandgevikas/bms:latest -f bookmyshow-app/Dockerfile bookmyshow-app

                            echo "Pushing Docker image to registry..."
                            docker push ghandgevikas/bms:latest
                            '''
                        }
                    }
                }
            }
        }
        stage('Deploy to Container') {
            steps {
                sh ''' 
                echo "Stopping and removing old container..."
                docker stop bms || true
                docker rm bms || true

                echo "Running new container on port 3000..."
                docker run -d --restart=always --name bms -p 3000:3000 ghandgevikas/bms:latest

                echo "Checking running containers..."
                docker ps -a

                echo "Fetching logs..."
                sleep 5
                docker logs bms
                '''
            }
        }
    }
    post {
        always {
            emailext attachLog: true,
                subject: "'${currentBuild.result}'",
                body: "Project: ${env.JOB_NAME}<br/>" +
                      "Build Number: ${env.BUILD_NUMBER}<br/>" +
                      "URL: ${env.BUILD_URL}<br/>",
                to: 'ghandgevikas804@gmail.com',
                attachmentsPattern: 'trivyfs.txt,trivyimage.txt'
        }
    }
}



---------------------------------------------------------------------------------------
===================================================================================

pipeline{
    agent any
    tools{
        jdk 'jdk17'
        nodejs 'node19'
    }
    environment {
        SCANNER_HOME=tool 'sonar-scanner'
    }
    stages {
        stage('Checkout from Git'){
            steps{
                git branch: 'main', url: 'https://github.com/Vikasghandge/Terrafrom-Repo.git'
            }
        }
        stage('Install Dependencies') {
            steps {
                sh "npm install"
            }
        }
        stage("Sonarqube Analysis "){
            steps{
                withSonarQubeEnv('sonar-server') {
                    sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=Chatbot \
                    -Dsonar.projectKey=Chatbot '''
                }
            }
        }
        stage("quality gate"){
           steps {
                script {
                    waitForQualityGate abortPipeline: false, credentialsId: 'Sonar-token'
                }
            }
        }
        stage('OWASP FS SCAN') {
            steps {
                dependencyCheck additionalArguments: '--scan ./ --disableYarnAudit --disableNodeAudit', odcInstallation: 'DP-Check'
                dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
            }
        }
        stage('TRIVY FS SCAN') {
            steps {
                sh "trivy fs . &gt; trivyfs.json"
            }
        }
        stage("Docker Build &amp; Push"){
            steps{
                script{
                   withDockerRegistry(credentialsId: 'docker', toolName: 'docker'){
                       sh "docker build -t chatbot ."
                       sh "docker tag chatbot sevenajay/chatbot:latest "
                       sh "docker push sevenajay/chatbot:latest "
                    }
                }
            }
        }
        stage("TRIVY"){
            steps{
                sh "trivy image sevenajay/chatbot:latest &gt; trivy.json"
            }
        }
        stage ("Remove container") {
            steps{
                sh "docker stop chatbot | true"
                sh "docker rm chatbot | true"
             }
        }
        stage('Deploy to container'){
            steps{
                sh 'docker run -d --name chatbot -p 3000:3000 sevenajay/chatbot:latest'
            }
        }
    }