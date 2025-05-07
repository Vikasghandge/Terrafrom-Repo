pipeline {
    agent any {
        stages {
            stage('Checkout Code') {
                steps {
                    'branch: main', url: 'htttp://github.com/vikasghandge/git'
                }
            }
        }
    }
}