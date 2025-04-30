pipeline {
    agent any 
    environment = 'docker-hub'
    IMAGE_NAME = nginx:latest
    stages {
        stage('Checkout') {
            steps {
                     git url: 'your git repo url'
            }
        }
        stage('Docker Image Build')
    }
}