pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'your git repo uurl'
            }
        }
        stage {
            
        }
    }
}