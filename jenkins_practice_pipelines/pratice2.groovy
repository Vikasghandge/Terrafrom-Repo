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
            steps {
                'your test like pom.xml url'
            }
        }
        stage('Deploy') {
            steps {
                sh 'we are deploying in production env'
            }
        }
     }
}