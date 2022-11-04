pipeline { 
     agent any
  
   stages{
        
       stage('GIT')
	    {
			steps {
					echo "Getting project from Git";
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
		
		
   }
}