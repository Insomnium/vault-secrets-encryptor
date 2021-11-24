pipeline {
    agents any
    stages {
        stage('Build & test') {
            steps {
                sh './gradlew clean build'
                echo 'done building'
            }
        }
        stage('QA deploy') {
            steps {
                echo 'Deploying to QA env'
            }
        }
        stage('Deploy to prod') {
            input {
                    message 'Deploy to prod?'
                    ok 'Yes, sure'
            }
            steps {
                echo 'Deploying to prod...'
            }
        }
    }
}