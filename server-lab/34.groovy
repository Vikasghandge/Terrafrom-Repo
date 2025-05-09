pipeline {
    agent any
    stages {
        stage('Checkout') {
            stpes {
                git 'your git repo url'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'Docker Build -t image_name ./my image_name'
            }
        }
        stage('Docker Push') {
            steps {
                withCredentials([userpassword(credentialsId: dockerhub-credentials, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                   
                   sh '''
                    echo '$DOCKER_PASS' |  docker login -u '$DOCKER_USER'
                        docker tag 
                        docker push image_name/vikasghandge   
                        '''   
                }
            }
        }
    }
}