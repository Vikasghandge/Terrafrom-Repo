pipeline {
    agent any 
    stages {
        stage('Chekout') {
            steps {
                git url: 'your git repo url and branch name'
            }
        }
        stage('')
    }
}