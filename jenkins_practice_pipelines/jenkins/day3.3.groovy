pipeline {
    agent any 
    DOCKER_IMAGE = vikas/nginx
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
        stage('Dokcer Push') {
            
        }

    }
}