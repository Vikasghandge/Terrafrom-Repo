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
        stage('')
    }
}