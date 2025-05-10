pipeline {
    agent any 

    stages{
        stage('Checkout Code') {
            steps {
                'branch: main', url: "http://github.com/vikasghandge/terraform.git"
            }
        }
        stage('build code') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('')
    }
}