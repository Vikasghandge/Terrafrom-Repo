#simple pipeline to build maven code.

pipeline {
    agent any 
    stages {
        stage('Chekout code from scm') {
            steps {
                git url: 'your git repo url'
            }
        }
        stage('Build') {
            steps {
                sh ''
            }
        }
    }
}