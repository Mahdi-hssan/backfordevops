pipeline { 
     agent any
  
   stages{
        
       
        stage('MVN CLEAN') { 
            steps { 
               sh' mvn clean install -DskipTests' 
                
            }
        }
		stage('SonarQube') {
			steps {
				script {
					withSonarQubeEnv('sonarQube') {
						sh' mvn sonar:sonar'
					}
				}
			}
		}
		stage ('NEXUS DEPLOYEMENT') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }
   }
}