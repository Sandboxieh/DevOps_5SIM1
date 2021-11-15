pipeline {

    environment { 
        registry = "dhiam/timesheet" 
        registryCredential = 'dhiam' 
        dockerImage = '' 
    }
    
	agent any

	stages{
		    
			// stage('Cloning our Git') { 
            //     steps { 
            //         bat "git clone -b Dhia-Mnasser --single-branch https://github.com/DhiaMnasser/TimeSheet-DevOps.git ."
            //       }
            // } 

            stage('pull and run mysql') { 
                steps { 
                    bat "docker container run --name mysqldb --network timesheet-network  -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=timesheet -d mysql:5.6"

                }
           }   
			stage('Package'){
				steps{
					bat "mvn package -DskipTests"
				}				
			}

			// stage('Test'){
			// 	steps{
			// 		bat "mvn test"
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
            
            stage('Building our image') { 
                steps { 
                    script { 
                    dockerImage = docker.build("$registry:$BUILD_NUMBER")
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

        //     stage('run images') { 
        //         steps { 
        //             // bat "docker run $registry:$BUILD_NUMBER" 
        //         }
        //    } 
        //     stage('create docker network') { 
        //         steps { 

        //             bat "docker network create timesheet-network"
 
        //         }
        //    }  
        
           stage('run images') { 
                steps { 
                    bat "docker container run --network timesheet-network --name timesheet-container -p 8083:8083 -d $registry:$BUILD_NUMBER"
                }
           } 
	}
	
	  post{
            always{
                emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
        
                cleanWs()
        }
    }
	 

}