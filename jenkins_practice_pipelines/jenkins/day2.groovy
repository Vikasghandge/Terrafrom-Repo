pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git url: git repo ulr
            }
        }
    }
}