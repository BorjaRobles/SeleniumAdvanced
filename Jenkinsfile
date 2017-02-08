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

        stage ('Build') {
                    steps {
                       "cmd /c mvn test".execute()
                    }
        }

    }
}