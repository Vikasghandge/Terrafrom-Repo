pipeline {
    agent any {
        stages {
            stage('Checkout Code') {
                'branch: main', url: 'htttp'
            }
        }
    }
}