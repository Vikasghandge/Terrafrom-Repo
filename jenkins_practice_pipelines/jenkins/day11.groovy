pipeline {
    angent any

    environment {
        DOCKERHUB_CREDENTIALS = 'docker-hub-cred'
        IMAGE_NAME = 'ghandgevikas/nginx:latest'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'your git repo url'
            }
        }
        stage
    }
}

