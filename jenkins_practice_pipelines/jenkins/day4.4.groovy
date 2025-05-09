# pipeline to build docker image than tag and push it into the dockerhub

pipeline {
    agent any 
    IMAGE_NAME = ghandgevikas/nginx
    TAG = latest
    stages {
        stage ('Chekout') {
            steps {
                git url: 'url of your git repo and branch name'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:TAG .'
            }
        }
        stage('Dockerhub login') {
            steps {
                withCredentials([usernamepassword(credentialsId: DOCKER_CREDENTIALS, usernameVariable: 'DOCKER_USER', usernamePassword: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }
        stage('Docker push registery') {
            steps {
                sh 'docker push $IMAGE_NAME:TAG'
            }
        }
    }
}