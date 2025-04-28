pipeline {
    agent any 
    stages {
        stage('Checkout') {
            steps {
                git url: 'url git repo url'
            }
        }
        stage('Docker b=')     
    }
}