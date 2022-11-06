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
		
		stage('MVN COMPILE'){
			steps {
				sh' mvn compile'
			}
		}
		
		stage('JUNIT/MOCKITO') {
            steps {
                sh 'mvn test'
            }
        }
		
		stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
		
		stage('PACKAGING DU LIVRABLE') { 
            steps { 
               sh' mvn clean -DskipTests' 
            }
        }
		
		stage('NEXUS DEPLOY ARTEFACT'){
            steps {
                sh 'mvn package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.140:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar -DskipTests'
            }
        }
		
		stage('DOCKER IMAGE BUILD'){
            steps {
                sh 'docker build -t elouninermine/tpachat .'
            }
        }
        stage('DOCKER LOGIN'){
            steps {
                sh 'docker login -u elouninermine -p admindocker'
            }
        }
        
        stage('DOCKER PUSH'){
            steps {
				sh 'docker push elouninermine/tpachat:tagname'
            }
        }
		
	
   }
}