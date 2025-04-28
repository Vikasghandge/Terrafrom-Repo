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
        stage('push image') {
            steps {
                withCredentials[(userpassword(dockerhub-credentialsId: usernameVariable, '$DOCKER_USER', passwordVariable, 'DOCKER_PASS'))] {
                    
                }
            }
        }
    }
}