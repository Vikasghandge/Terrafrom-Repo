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
                    sh ''' 
                    echo '$DOCKER_PASS | docker login -u '$DOCKER_USER'
                    docker tag image_name/tag:tagname
                    docker push image_name
                    '''
                }
            }
        }
    }
}