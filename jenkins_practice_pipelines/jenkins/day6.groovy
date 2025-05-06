pipeline {
    agent any 
    stages{
        stage('Checkout') {
            steps {
                git url: 'https://github.com/your-user/your-repo.git', branch:'main'
            }
        }
        stage('Build') {
            
        }
    }
}