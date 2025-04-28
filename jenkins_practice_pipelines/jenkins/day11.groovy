pipeline {
    angent any

    environment {
        DOCKERHUB_CREDENTIALS = 'docker-hub-cred'
        IMAGE_NAME = 'ghandgevikas/nginx:latest'
    }
}