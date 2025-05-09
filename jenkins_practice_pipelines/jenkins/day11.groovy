pipeline {
    angent any

    environment {
        DOCKERHUB_CREDENTIALS = 'docker-hub-cred'
        IMAGE_NAME = 'ghandgevikas/nginx:latest'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'your git repo url'
            }
        }
        stage('Build Docker Image') {
            stpes {
                script {
                    sh 'docker build -t $IMAGE_NAME'
                }
            }
        }
        stage('Login to DockerHub') {
            steps {
                withCredentilas([usernamepassword(credentialsId: '$DOCKER_CREDENTIALS', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo "$DOCKERPASS" | docker login -u "$DOCKER_USER" --password-stdin'
                    
                }
            }
        }
        stage('Docker Push Image') {
            steps {
                script {
                    sh 'docker push $DOCKER_IMAGE'
                }
            }
        }
        stage('Deploying on k8s Cluster') {
            steps {
                script {
                    sh '''
                    kubectl apply -f deployment.yml
                    kubectl get pods
                    kubectl get svc
                    '''
                }
            }
        }
    }
}

