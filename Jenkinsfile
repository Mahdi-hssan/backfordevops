pipeline { 
     environment { 

        registry = "amanibh/tpachat" 

        registryCredential = 'dockerHub' 

        dockerImage = ''

    }
     agent any
  
   stages{
        stage('GIT') { 
            steps { 
               git branch: 'amani', credentialsId: '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', url: 'https://github.com/HssanMahdi/backfordevops.git'
                
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

         //stage("Unit tests") {
         //   steps {
         //         sh "mvn test -DskipTests"
         //   }
        // }

         stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }

        stage ('NEXUS DEPLOY') {
            steps {
                sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://172.10.0.140:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar -DskipTests'
            }
        }
        stage('Building our image') {
			steps {
				script {
					dockerImage = docker.build registry + ":$BUILD_NUMBER"
					}
				}
		}

      //   stage('Deploy our image') {
      //    steps {
      //    script {
      //        docker.withRegistry( '', registryCredential ) {
      //        dockerImage.push()
      //          }
      //       }
      //     }
      //   }

         stage('pushing Image'){
               steps{
                     script{
                  sh 'docker login -u "amanibh" -p "amani1234"'
                  sh ' docker push amanibh/tpachat'
         }
         }
         }



       stage('Cleaning up') {
			steps {
				sh "docker rmi $registry:$BUILD_NUMBER"
			}
		}
        
       
        
   }
}
