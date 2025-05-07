
# this is pipeline will checkout code then it will build image and it will push into the docker registery.
 
 pipeline {
    agent any 
    environment {
        IMAGE_NAME = ghandgevikas/nginx
        TAG = latest
        

        stages {
            stage('Chekout code') {
                steps {
                    'branch: main', url: 'htttp://github.com/vikasghandge/git'
                }
            }
            stage('Docker Image Build') {
                steps {
                    sh 'docker build -t $IMAGE_NAME:TAG .'
                }
            }
            stage('')
        }
    }
 }