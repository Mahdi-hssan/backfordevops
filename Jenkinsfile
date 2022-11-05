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
		
		stage('MVN NEXUS'){
            steps {
                sh 'mvn clean deploy'
            }
        }
		
   }
}