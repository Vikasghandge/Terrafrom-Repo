pipeline {
    agent any 

    stages {
        stage('Chekout Code') {
            steps {
                'branch: main', url: 'http://github.com/vikasghandge/terraform.git'
            }
        }
        stage('Terraform Version') {
            steps {
                sh 'terraform --version'
            }
        }
        stage('Terraform init') {
            steps {
                dir('terraform') {
                    sh 'terraform init'
                }
            }
        }
        stage('Terraform Validate') {
            steps {
                dir('terraform') {
                    sh 'terraform validate'
                }
            }
        }
        stage('Terraform Plan') {
            steps {
                dir('terraform') {
                    sh 'terraform plan'
                }
            }
        }
        stage('Terraform Apply/Destroy') {
            steps {
                dir('terraform')
            }
        }
    }
}