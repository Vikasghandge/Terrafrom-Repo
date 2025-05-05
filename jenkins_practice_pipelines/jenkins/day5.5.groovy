pipeline {
    agent any 
    IMAGE_NAME = ghandevikas/nginx
    TAG = latest
    
    stages{
        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-user/your-repo.git', branch: 'main'
            }
        }
        stage('Docker Build Image') {
            steps {
                docker build -t $IMAGE_NAME:TAG .
            }
        }
    }
}