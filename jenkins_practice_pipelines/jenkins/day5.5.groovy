pipeline {
    agent any 
    IMAGE_NAME = ghandevikas/nginx
    TAG = latest
    
    stages{
        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-user/your-repo.git', branch: 'main'
            }
        }
        stage('Docker Build Image') {
            steps {
                docker build -t $IMAGE_NAME:$TAG .
            }
        }
        stage('Docker Login') {
            steps {
                withCredentials([usernamepassword(credentialsId: DOCKERHUB_CREDENTIALS, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER' --password-stdin
                }
            }
        }
        stage('Push into DockerHub') {
            steps {
                sh 'docker push $IMAGE_NAME:$'
            }
        }
    }
}