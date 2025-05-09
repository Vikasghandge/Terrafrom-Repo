pipeline {
    agent any 
    environment {
        IMAGE_NAME = ghandgevikas/nginx
        TAG = latest
    }
    stages{
        stage('Checkout Code') {
            steps {
                branch 'main' url:'https://github.com/your-user/your-repo.git'
            }
        }
        stage('Docker Build Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:TAG .'
            }
        }
        stage('Docker Login Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId, 'DOCKERHUB_CREDENTIALS', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKE_PASS | docker login -u $DOKCER_USER' --password-stdin
                }
            }
        }
        stage('Docker Push Image Into Registery') {
            steps {
              sh  'docker push "$IMAGE_NAME":"$TAG"'
            }
        }
    }
}