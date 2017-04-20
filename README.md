# SeleniumAdvanced
A Docker Selenium Grid test which invokes Lufthansa home page and verifies its title


This project has been created for demonstrating the use of Docker Selenium images in running automated tests in CI Jenkins pipeline.

Important Files:

Jenkinsfile - Docker Commands Usage

      First, you will need a Selenium Grid Hub that the Node will connect to.

      $ docker run -d -P --name selenium-hub selenium/hub

      Once the hub is up and running will want to launch nodes that can run tests. You can run as many nodes as you wish.

      $ docker run -d --link selenium-hub:hub selenium/node-chrome

      Then run your tests using maven

DockerGridTest.java - Runs a simple test using TestNG Framework

      By default Docker hub will connect available in the port 32768, so you can use 'http://localhost:32768/wd/hub'.
      
      'docker ps -a' command will let you port in which Docker Selenium hub is running.

I believe rest of the content should look very familiar to you.  Please let me know if you have any questions.
