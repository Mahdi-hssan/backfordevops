pipeline { 
     agent any
  
   stages{
        
       
        stage('MVN CLEAN') { 
            steps { 
               sh' mvn clean install -DskipTests' 
                
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
		stage ('NEXUS DEPLOYEMENT') {
            steps {
                script {
					nexusPublisher nexusInstanceId: 'Nexus', nexusRepositoryId: 'TpAchat', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/tpAchatProject-1.0.jar']], mavenCoordinate: [artifactId: 'tpAchatProject', groupId: 'com.esprit.examen', packaging: 'jar', version: '1.0']]]
				}
            }
        }
   }
}

