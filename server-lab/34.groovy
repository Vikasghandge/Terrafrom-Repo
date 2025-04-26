pipeline {
    agent any
    stages {
        stage('Checkout') {
            stpes {
                git 'your git repo url'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'Docker Build -t image_name ./my image_name'
            }
        }
        stage('Docker Push') {
            s {
                withCredentials([userpassword(credentialsId: dockerhub-credentials, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {

                }
            }
        }
    }
}