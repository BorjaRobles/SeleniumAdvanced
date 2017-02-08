pipeline {
    agent any
    triggers {
        cron('H / 5 ****')
    }
    stages {
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}