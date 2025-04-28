pipeline {
    agent any
    stgaes {
        stage ('Checkout') {
            steps {
                git url: ' your git repo url '
            }
        }
        stage()
    }
}