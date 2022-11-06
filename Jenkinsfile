pipeline { 
	environment { 

        registry = "mahdihssan/tpachat" 

        registryCredential = 'dockerHub' 

        dockerImage = ''

    }
     agent any
  
   stages{
		stage('GIT') { 
            steps { 
               git branch: 'Mahdi', credentialsId: 'ba764ef7-06cb-459e-9507-e1179a361ce9', url: 'https://github.com/HssanMahdi/backfordevops.git'
                
            }
         }
        /*stage('MVN CLEAN') { 
            steps { 
               sh' mvn clean install -DskipTests' 
                
            }
         }*/

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
		stage("Unit tests") {
			steps {
				sh "mvn install test"
			}
			post {
				always {
					junit 'target/surefire-reports/*.xml'
				}
			}
		}
		stage('clean et packaging'){
			steps {
				sh 'mvn clean package -DskipTests'
			}
		}
		/*stage ('NEXUS DEPLOY') {
            steps {
				script {
					nexusPublisher nexusInstanceId: 'Nexus', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/tpAchatProject-1.0.jar']], mavenCoordinate: [artifactId: 'tpAchatProject', groupId: 'com.esprit.examen', packaging: 'jar', version: '1.0']]]
				}
            }
        }
		stage('Building our image') {
			steps {
				script {
					dockerImage = docker.build registry + ":$BUILD_NUMBER"
					}
				}
		}
		stage('Deploy our image') {
         steps {
         script {
             docker.withRegistry( '', registryCredential ) {
             dockerImage.push()
               }
            }
          }
        }
		stage('Cleaning up') {
			steps {
				sh "docker rmi $registry:$BUILD_NUMBER"
			}
		}
		stage('Email notification') {
            steps {
                mail bcc: '', body: 'Image is pushed to Dockerhub', cc: '', from: '', replyTo: '', subject: 'Jenkins-Dockerhub Alert', to: 'mahdi.hssan@esprit.tn'
            }
        }
		stage("Docker-Compose") { 
             steps { 
                 script { 
                    sh "docker-compose up -d  "
                 } 
             } 
        }*/
		/*stage("Run containers") {
            steps {
                sh "docker-compose up -d"
                sleep(time: 30, unit: "MINUTES")
                sh 'docker compose ps'
                sh "docker-compose down"
                sh 'docker compose ps'
            }
        }*/
   }
}

