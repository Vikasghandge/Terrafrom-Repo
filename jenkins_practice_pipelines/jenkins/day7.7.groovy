
# this is pipeline will checkout code then it will build image and it will push into the docker registery.
 
 pipeline {
    agent any 
    environment {
        IMAGE_NAME = ghandgevikas/nginx
        TAG = latest
        

        stages {
            stage('Chekout code') {
                steps {
                    
                }
            }
        }
    }
 }