pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps{
                git url: 'url of your git repo'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('test') {
            steps {
                'tesing here'
            }
        }
    }
}