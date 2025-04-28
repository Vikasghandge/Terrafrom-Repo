pipeline {
    agent any
    stgaes {
        stage ('Checkout') {
            steps {
                git url: ' your git repo url '
            }
        }
        stage('Build Image') {
            steps {
                sh ' your image '
            }
        }
    }
}