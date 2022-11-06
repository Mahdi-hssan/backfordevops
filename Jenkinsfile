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
            steps {
                sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.140:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar -DskipTests'
            }
        }
		
   }
}