node(){
       stage('test') {
          def mvnHome
          mvnHome = tool 'MAVEN_HOME'
          env.JAVA_HOME = tool 'JDK-1.8'
          bat(/"${mvnHome}\bin\mvn" test "/)
       } // end stage
}