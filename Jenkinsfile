pipeline {

    environment { 
        registry = "hassenbenabid/timesheet" 
        registryCredential = 'dockerhub-cred' 
        dockerImage = '' 
    }
    
	agent any

	stages{
		    
			// stage('Cloning our Git') { 
            //     steps { 
            //         bat "git clone -b Dhia-Mnasser --single-branch https://github.com/DhiaMnasser/TimeSheet-DevOps.git ."
            //       }
            // } 

             stage('Mysql pull and run') { 
                 steps { 
                     bat "docker container run --name mysqldb --network timesheet-network  -e MYSQL_ROOT_PASSWORD=root -e  MYSQL_DATABASE=timesheet -d mysql:5.6"

                 }
            }   
			stage('Package'){
				steps{
					bat "mvn package -DskipTests"
				}				
			}

			// stage('Test'){
			// 	steps{
			// 		bat "mvn test"m
			// 	}				
			// }

			stage('Sonar Analyse'){
				steps{
                    bat "mvn sonar:sonar -DskipTests"
                  }
            }
            
            stage('Nexus Deploy'){
				steps{
                    bat "mvn deploy -DskipTests"
                  }
            }
            
            stage('Building image') { 
                steps { 
                    script { 
                    dockerImage = docker.build("$registry:$BUILD_NUMBER")
                    }
                } 
            }

          stage('Deploy image') { 
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
                    bat "docker rmi $registry:$BUILD_NUMBER" 
               //   bat "docker rmi mysqldb" 
                }
           } 

		    stage('Pulling from docker hub') { 
                steps { 
                    script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.pull() 
                    }
                } 
             }
           } 
        
           stage('run images') { 
                steps { 
                    bat "docker container run --network timesheet-network --name timesheet-container -p 8088:8088 -d $registry:$BUILD_NUMBER"
                }
           } 
	}
	

}