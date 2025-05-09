pipeline {
    agent any

    tools {
        jdk 'jdk17'
        nodejs 'node19'
    }

    environment {
        SCANNER_HOME = tool 'sonar-scanner'  // Ensure this is defined in Jenkins' Global Tool Configuration
    }

    stages {
        stage('Checkout from Git') {
            steps {
                git branch: 'main', url: 'https://github.com/Vikasghandge/Terrafrom-Repo.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                dir('chatbot-ui-legacy') {
                    sh 'npm install'  // Install Node.js dependencies inside the specified directory
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar-server') {  // Ensure 'sonar-server' is configured in Jenkins
                    sh '''$SCANNER_HOME/bin/sonar-scanner \
                        -Dsonar.projectName=Chatbot \
                        -Dsonar.projectKey=Chatbot'''
                }
            }
        }

        stage('Quality Gate') {
            steps {
                script {
                    // Wait for the SonarQube Quality Gate and abort if it's failing
                    waitForQualityGate abortPipeline: false, credentialsId: 'Sonar-token'  // Ensure this token is correctly set in Jenkins credentials
                }
            }
        }

        // stage('OWASP FS Scan') {
           // steps {
                // Run OWASP Dependency Check in the 'chatbot-ui-legacy' directory
             //   dir('chatbot-ui-legacy') {
               //     dependencyCheck additionalArguments: '--scan ./ --disableYarnAudit --disableNodeAudit', odcInstallation: 'DP-Check'
                 //   dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
               // }
            //}
        //}

        stage('TRIVY FS Scan') {
            steps {
                // Run Trivy on the file system and save the result in a JSON file
                sh 'trivy fs chatbot-ui-legacy > trivyfs.json'
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    dir('chatbot-ui-legacy') {
                        // Build the Docker image, tag it, and push it to Docker Hub
                        withDockerRegistry(credentialsId: 'docker', toolName: 'docker') {
                            sh 'docker build -t chatbot .'
                            sh 'docker tag chatbot ghandgevikas/chatbot:latest'
                            sh 'docker push ghandgevikas/chatbot:latest'
                        }
                    }
                }
            }
        }

        stage('TRIVY Image Scan') {
            steps {
                // Scan the Docker image using Trivy
                sh 'trivy image ghandgevikas/chatbot:latest > trivy.json'
            }
        }

        stage('Remove Old Container') {
            steps {
                // Stop and remove any existing containers before starting a new one
                sh 'docker stop chatbot || true'
                sh 'docker rm chatbot || true'
            }
        }

        stage('Deploy to Container') {
            steps {
                // Run the Docker container with port mapping
                sh 'docker run -d --name chatbot -p 3000:3000 ghandgevikas/chatbot:latest'
            }
        }
    }
}
