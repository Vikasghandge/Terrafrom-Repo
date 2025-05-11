

// here defined dcoker stages build, login, tag, and push //

pipeline {
    agent any 

    environment {
        IMAGE_NAME = ghandgevikas/nginx
        TAG = latest

        stages {
            stage('Chekout Code') {
                stpes {
                    'branch: main', url: 'http://github.com/vikasghandge/terraform.git'
                }
            }
            stage('Docker Build Image') {
                steps {
                    sh 'docker build -t $IMAGE_NAME:$TAG .'
                }
            }
            stage('Docker Login DockerHub') {
                steps {
                    withCredentials([usernamePassword(CredentialsId: 'DOCKERHUB_CREDENTAILS, us')])
                }
            }
        }
    }


}