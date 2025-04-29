pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: 'git repo ulr'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage
    }
}