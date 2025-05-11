

// here defined dcoker stages build, login, tag, and push //

pipeline {
    agent any 

    environment {
        IMAGE_NAME = ghandgevikas/nginx
        TAG = latest

        stages {
            stage('Chekout Code') {
                stpes {
                    'branch: main', ''
                }
            }
        }
    }


}