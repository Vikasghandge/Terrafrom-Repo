pipeline {
    agent any 
    DOCKER_IMAGE = ghandgevikas/nginx
    TAG = latest 

    stages {
        stage('checkout') {
            steps {
                checkout scm 'your repo url'
            }
        }
        stage('Build Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE:$TAG .'
            }
        }
        stage('Docker Login') {
            steps {
                 withCredentilas([usernamepassword(credentialsId: $DOCKER_CREDENTIALS, usernameVariable: DOCKERHUB_USER, passwordVariable: DOCKER_PASSS)]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                 }
            }
        }
        stage('Docker Push') {
            steps {
                sh 'docker push $DOCKER_IMAGE:TAG .'
            }
        }

    }
}