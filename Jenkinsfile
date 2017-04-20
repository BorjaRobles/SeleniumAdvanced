pipeline {
    agent any
    tools { // <1>
        maven 'maven 3.3.9' // <2>
        jdk 'jdk8' // <3>
    }
    stages {
        stage ('Initialize') {
            steps {
                println("Initialize")
            }
        }

        stage ('Build') {
            steps {
               println("Build")
            }
        }

        stage ('test') {
                    steps {
		       sh "docker run -d -P --name selenium-hub selenium/hub"
		       sh "docker run -d --link selenium-hub:hub selenium/node-chrome"
                       sh "mvn test"
                    }
        }

    }
}
