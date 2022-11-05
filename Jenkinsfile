pipeline { 
     agent any
  
   stages{
        
		stage('GIT') { 
            steps { 
               git branch: 'Mahdi', credentialsId: 'ba764ef7-06cb-459e-9507-e1179a361ce9', url: 'https://github.com/HssanMahdi/backfordevops.git'
                
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
		/*stage('SonarQube') {
			steps {
				script {
					withSonarQubeEnv('sonarQube') {
						sh' mvn sonar:sonar'
					}
				}
			}
		}*/
		stage ('NEXUS DEPLOY') {
            steps {
                sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.13:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar -DskipTests'
            }
        }
   }
}

