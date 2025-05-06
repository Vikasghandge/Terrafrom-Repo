pipeline {
    agent any 
    environment {
        IMAGE_NAME = ghandgevikas/nginx
        TAG = latest
    }
    stages{
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/your-user/your-repo.git', 'branch: main'
            }
        }
        stage('Docker Build Image') {
            steps {
                sh 'docker build -t "$IMAGE_NAME'
            }
        }
    }
}