pipeline {
    agent any 

    stages {
        stage('Chekout Code') {
            steps {
                'branch: main', url: 'http://github.com/vikasghandge/terraform.git'
            }
        }
        stage
    }
}