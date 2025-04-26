pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'your git repo uurl'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                
            }
        }
    }
}