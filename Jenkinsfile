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

          stage('MVN COMPILE') { 
            steps { 
               sh 'mysql -h localhost -P 3306 -u root -p tpachato & mvn clean install -DskipTests'
            }
         }
         
        stage('JUNIT TESTS'){
             steps{
                sh 'mvn test'
             }
         }
	
	    stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }
	
	    stage('PREPARATION DU LIVRABLE') {
		    steps {
			    sh 'mvn package -DskipTests'
	    	}
    	}
		
    	stage ('NEXUS DEPLOY') {
    	    steps {
                sh 'mvn deploy -DskipTests'
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
		
		stage('CLEAN DOCKER IMAGE') {
			steps {
				sh "docker rmi $registry:$BUILD_NUMBER"
			}
		}

    }
}