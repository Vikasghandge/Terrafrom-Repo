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
                echo ""
            }
        }
    }
}