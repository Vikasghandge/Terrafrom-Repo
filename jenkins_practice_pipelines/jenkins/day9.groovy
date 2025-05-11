// this pipeline define mvn deployment stages //

pipeline {
    agent any 

    stages {
        stage('Checkout Code') {
            steps {
                'branch: main', url: 'http://github.com/vikasghandge/terraform.git'
            }
        }
        stage('Build Code') {
            steps {
                sh 'mvn install clean'
            }
        }
        stage('Test locally') {
            steps {
                echo 'testing locally'
            }
        }
        stage('Deploy') {
            steps {
                echo 'deploying in local env'
            }
        }
    }
}

// mvn lifecycle//
mvn clean install -- // it will clean old build
mvn compile -- // this will compile code into computer language
mvn package -- // will package codes dependency, libery
mvn test -- // test ocall y