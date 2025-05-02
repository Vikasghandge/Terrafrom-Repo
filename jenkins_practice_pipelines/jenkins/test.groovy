pipeline {
    agent any
    environment {
        AWS_ACCESS_KEY_ID = credentials('AWS_Access_Key')
        AWS_SECRET_ACCESS_KEY = credentials('AWS_Secret_Key')
        AWS_DEFAULT_REGION = 'ap-south-1'
    }
    stages{
        stage('Clone the Code'){
            steps{
                script{
                    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/KastroVKiran/Jenkins-Terraform-EKS.git']])
                }
            }
        }
        stage('Terraform Initialization'){
            steps{
                script{
                    dir('eks-cluster-setup'){
                         sh 'terraform init'
                    }
                }
            }
        }
        stage('Terraform Validation'){
            steps{
                script{
                    dir('terraform'){
                         sh 'terraform validate'
                    }
                }
            }
        }
        stage('Infrastructure Checks'){
            steps{
                script{
                    dir('terraform'){
                         sh 'terraform plan'
                    }
                    input(message: "Approve?", ok: "proceed")
                }
            }
        }
        stage('Create/Destroy EKS cluster'){
            steps{
                script{
                    dir('terraform'){
                         sh 'terraform $action --auto-approve'
                    }
                }
            }
        }
    }
}
