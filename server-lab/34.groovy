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
                'location of your pom.xml file'
            }
        }
        stage('Deploy') {
            stpes {
                sh 'echo "we are deploying in test env"'
            }
        }
    }
}