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
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
   }
}