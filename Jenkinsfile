pipeline { 
    
    environment{
	    registry= "elouninermine/tpachat"
	    dockerImage=''
	    registryCredential= 'dockerHub'
    }
    agent any

    stages{
	stage('GIT') {
            steps {
                git branch : 'nermine',
				credentialsId:'39868df3-95ce-4996-9918-b3a1ebef790c',
                url: 'https://github.com/HssanMahdi/backfordevops.git'
            }
        }
        
        stage('MVN CLEAN') { 
            steps { 
               sh' mvn clean install -DskipTests' 
                
            }
         }

          stage('MVN COMPILE') { 
            steps { 
               sh 'mvn compile'
            }
         }
         
        stage('JUNIT/MOCKITO TESTS'){
             steps{
                sh 'mysql -h localhost -P 3306 -u root -p tpachato & mvn test -DskipTests'
             }
         }
	
	    stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
	
	    stage('PREPARATION DU LIVRABLE') {
		    steps {
			    sh 'mvn clean package -DskipTests'
	    	}
    	}
		
    	stage ('NEXUS DEPLOY') {
    	    steps {
                sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.11:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar -DskipTests'
    	    }
        }
		
	    stage('DOCKER IMAGE BUILD') {
		    steps {
			    script {
				    dockerImage = docker.build registry + ":$BUILD_NUMBER"
			    }
		    }
        }
    
        stage('DEPLOY DOCKER IMAGE') {
		    steps{
			    script{
				    docker.withRegistry( '', registryCredential ){
					    dockerImage.push();
				    }
			    }
		    }
	    }
	    
	    stage('NOTIFICATION EMAIL') {
            steps {
                mail bcc: '', body: 'Image is pushed to Nermine DockerHub', cc: '', from: '', replyTo: '', subject: 'Jenkins-Dockerhub Alert', to: 'elouni.nermine@esprit.tn'
            }
        }
		
		stage('CLEAN DOCKER IMAGE') {
			steps {
				sh "docker rmi $registry:$BUILD_NUMBER"
			}
		}

    }
}