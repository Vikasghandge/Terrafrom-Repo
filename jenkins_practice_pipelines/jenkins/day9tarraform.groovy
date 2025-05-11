pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                'branch: main', url: 'http://github.com/vikasghandge/docker.git'
            }
        }
        stage('Terraform init') {
            steps {
                sh ''
            }
        }
    }


}