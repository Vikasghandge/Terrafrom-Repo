pipeline {
    agent any 
    environment {
        IMAGE_NAME = ghandgevikas/nginx
        TAG = latest
    }
    stages{
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/your-user/your-repo.git', 'branch: main'
            }
        }
        stage('Docker Build Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:TAG .'
            }
        }
        stage('Docker Login Hub') {
            steps {
                withCredentials([usernamepassword(credentialsId, DOCKERHUB_CREDENTIALS, usernameVariabe: 'DOCKER_USER', passwordVariable: 'DOKCER_PASS')]) {
                    sh 'echo $DOCKE_PASS | docker login -u $DOKCER_USER' --password-stdin
                }
            }
        }
        stage('Docker Push Image Into ')
    }
}