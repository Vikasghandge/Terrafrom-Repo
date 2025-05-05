pipeline {
    agent any 
    IMAGE_NAME = ghandevikas/nginx
    TAG = latest
    
    stages{
        stage('Check')
    }
}