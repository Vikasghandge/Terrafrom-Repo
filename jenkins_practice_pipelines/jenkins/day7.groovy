pipeline {
    agent any {
        stages {
            stage('Checkout Code') {
                steps {
                    'branch: main', url: 'htttp://github.com/vikasghandge/git'
                }
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'testing locally'
            }
        }
        stage('Deploy') {
            steps {
                echo 'deploying in local environment'
            }
        }
    }
}


mvn lifecycle --> checkout - compile - build - test - package -