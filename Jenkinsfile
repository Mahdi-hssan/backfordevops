pipeline { 
     agent any
  
   stages{
        stage('GIT') { 
            steps { 
               echo'git' 
                
            }
         }
        stage('MVN CLEAN') { 
            steps { 
               sh' mvn clean install -DskipTests' 
                
            }
         }

          stage('MVN COMPILE') { 
            steps { 
               sh' mvn compile' 
                
            }
         }

         stage('MVN SONARQUBE') { 
            steps { 
               withSonarQubeEnv('sonarqube.8.9.7') { 
               sh' mvn sonar:sonar' 
                
            }
            }
         }
   }
}