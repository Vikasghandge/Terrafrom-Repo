// this pipeline define mvn deployment stages //

pipeline {
    agent any 

    stages {
        stage('Checkout Code') {
            steps {
                'branch: main', url: 'http://github.com/vikasghandge/terraform.git'
            }
        }
        stage('Build Code') {
            steps {
                sh 'mvn install clean'
            }
        }
        stage
    }
}