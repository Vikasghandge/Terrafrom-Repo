pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                git url: 'url of your github repo and branch name'
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                'testing locally'
            }
        }
        stage()
    }
}