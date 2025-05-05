pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                git url: 'url of your git'
            }
        }
    }
}