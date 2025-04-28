pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'your git hub repo url and branch name'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            
        }
     }
}