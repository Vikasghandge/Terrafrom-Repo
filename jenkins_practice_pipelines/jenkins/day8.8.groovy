// in this script i have gave steps to how to build docker image, tag ,login ,& push steps

pipeline {
    agent any

    environment {
        IMAGE_NAME = ghandgevikas/nginx
        TAG = latest

        stages {
            stage('Checkout Code') {
                steps {
                    'branch: main', url:'http://github.com/vikasghandge/terraform.git'
                }
            }
        }
        stage('Docker Image Build') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$TAG .'
            }
        }
        stage('Docker Login') {
            steps {
                withCredentilas([usernamePassword(CredentialsId: 'DOCKERHUB_CREDENTILAS', usernameVariable: 'DOCKER_USER', passwordVaraible: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER' --password-stdin
                }
            }
        }
        stage('DockerHub Push') {
            steps {
                docker push '$IMAGE_NAME:'
            }
        }
    }
}