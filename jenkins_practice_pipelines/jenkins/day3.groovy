pipeline {
    agent any 
    stages {
        stage('Chekout') {
            steps {
                git url: 'your git repo url and branch name'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn install clean'
            }
        }
        stage('Test') {
            steps {
                'testing steps'
            }
        }
        stage('Deploy') {
            steps {
                sh 'deploying in local environment'
            }
        }
    }
}