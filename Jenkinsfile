pipeline { 
     agent any
  
   stages{
        
       stage('GIT') {
            steps {
                echo "git";
                git branch : 'nermine',
                url: 'https://github.com/LaracodeEsprit/Projet-DevOps.git'
            }
        }
		
        stage('MVN CLEAN') { 
            steps { 
               sh' mvn clean install -DskipTests' 
                
            }
        }
		
		stage('MVN COMPILE'){
			steps {
				sh' mvn compile'
			}
		}
		
		stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
		
		stage('JUNIT/MOCKITO') {
            steps {
                sh 'mvn test'
            }
        }
		
		stage('NEXUS DEPLOY'){
            script {
					nexusPublisher nexusInstanceId: 'Nexus', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/tpAchatProject-1.0.jar']], mavenCoordinate: [artifactId: 'tpAchatProject', groupId: 'com.esprit.examen', packaging: 'jar', version: '1.0']]]
			}
        }
		
   }
}