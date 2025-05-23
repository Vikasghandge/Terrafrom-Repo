pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                'branch: main', url: 'http://github.com/vikasghandge/docker.git'
            }  // pull code from repo //
        }
        stage('terraform version') {
            steps {
                sh 'terraform --verison'  // verify version and installations //
            }
        }
        stage('Terraform init') {
            steps {
                sh 'terraform init' // init backend dir and install aws plugins //
            }
        }
        stage('Terraform validate') {
            steps {
                sh 'terraform validate' // it will validate //
            }
        }
        stage('Terraform Plan') {
            steps {
                sh 'terrform plan'  // it will show preview changes before applying //
            }
        }
        stage('terrform apply/destroy') {
            steps {
                dir(terraform) {
                    sh 'terraform ${action} --auto-approve '  //apply or destroy infra//
                }
            }
        }
    }


}

