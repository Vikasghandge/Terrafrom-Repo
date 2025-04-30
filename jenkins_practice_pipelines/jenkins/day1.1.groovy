pipeline {
    agent any 
    environment = 'docker-hub'
    IMAGE_NAME = nginx:latest
    stages {
        stage('Checkout') {
            steps {

            }
        }
    }
}