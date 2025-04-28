pipeline {
    agent any 
    stages {
        stage('Checkout') {
            steps {
                git url: ''
            }
        }     
    }
}