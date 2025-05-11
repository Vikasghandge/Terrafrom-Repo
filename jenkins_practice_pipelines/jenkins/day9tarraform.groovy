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
                sh 'terraform init'
            }
        }
        stage('Terraform validate') {
            steps {
                sh 'terraform validate'
            }
        }
        stage('Terraform Plan') {
            steps {
                sh 'terrform plan'
            }
        }
        stage('terrform apply/destroy') {
            steps {
                dir
            }
        }
    }


}