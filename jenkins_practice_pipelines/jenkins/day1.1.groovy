pipeline {
    agent any 
    environment = 'docker-hub'
    IMAGE_NAME = nginx:latest
    stages {
        stage('Checkout') {
            steps {
                     git url: 'your git repo url'
            }
        }
        stage('Docker Image Build') {
            steps {
                script {
                    sh 'docker image build -t $IMAGE_NAME'
                }
            }
        }
        stage('Login Into DockerHub') {
            steps {
                script {
                    withCredentials([usernamepassword(credentials: 'DOCKERHUB-CREDENTIALS', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        sh 'echo "$DOCKER_PASS" | docker login -u "DOCKER_USER" --password-stdin'
                    }
                }
            }
        }
        stage('Push into DockerHub') {
            steps {
                script {
                    sh 'docker tag '$IMAGE_NAME/docker registeryusername''
                    sh 'docker push registryusername/'
                }
            }
        }
    }
}