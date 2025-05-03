# pipeline to build docker image than tag and push it into the dockerhub

pipeline {
    agent any 
    IMAGE_NAME = ghandgevikas/nginx
    TAG = la
}