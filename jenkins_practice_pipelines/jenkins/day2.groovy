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
        stage('Test') {
            steps {
                'pox.xml file path'
            }
        }
        stage('Deploy') {
            steps {
               sh ' echo 'deploying into env '
            }
        }
    }
}