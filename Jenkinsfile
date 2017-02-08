Jenkinsfile (Declarative Pipeline)
pipeline {
    agent any
    triggers {
        cron('H / 5 ****')
    }
    tools {
        maven 'apache-maven-3.0.1' /* <1> */
    }
    stages {
        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}