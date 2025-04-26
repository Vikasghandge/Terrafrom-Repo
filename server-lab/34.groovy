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
                sh ''
            }
        }
    }
}