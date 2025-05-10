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
        stage('Test') {
            steps {
                echo "testing locally"
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying locally"
            }
        }
    }
}

// maven lifecycle//
// Checkout -  fetch from github
// compile - which will compile code into computer language.
// build - which will build code
// package - which will package all de