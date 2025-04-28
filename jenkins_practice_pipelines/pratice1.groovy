pipeline {
    agent any
    stgaes {
        stage ('Checkout') {
            steps {
                git
            }
        }
    }
}