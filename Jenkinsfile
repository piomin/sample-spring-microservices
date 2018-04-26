#!/usr/bin/env groovy
def isAccountChanged = true
def isCustomerChanged = true
def isDiscoveryChanged = false
def isGatewayChanged = false
node {  
        stage('checkout') 
{         
checkout scm     
}
        stage('Check for CHANGELOG update') {
                    sshagent(['Credential Name']) {
                       // sh "git config --add remote.origin.fetch +refs/heads/master:refs/remotes/origin/master"
                        //sh "git fetch --no-tags"
                        List<String> sourceChanged = sh(returnStdout: true, script: "git diff --name-only HEAD^ origin/${env.BRANCH_NAME}").split()
                        for (int i = 0; i < sourceChanged.size(); i++) {
                            echo "** Here ***"
                            if (sourceChanged[i].contains("account")) {
                                isAccountChanged  = true
                            }
                            if (sourceChanged[i].contains("customer")) {
                                isCustomerChanged = true
                            }
                            if (sourceChanged[i].contains("discovery")) {
                                isDiscoveryChanged = true
                            }
                            if (sourceChanged[i].contains("gateway")) {
                                isGatewayChanged = true
                            }
                        }

                    }
                }
            }
def micro() {
            stage('checkout') {

                sh "pwd ;chmod +x script.sh"
                sh "pwd ; ./script.sh "
                    
            }
            stage('scrip') {

                sh "pwd ;chmod +x scrip.sh"
                sh "pwd ; ./scrip.sh "
                    
            }
           stage('checkout2') {

                sh "pwd ; chmod +x script.sh"
                sh "./script.sh "
                    
            }
            stage('scrip2') {

                sh "pwd ; chmod +x scrip.sh"
                sh "pwd ; ./scrip.sh "
                    
            }     
}
       
 stage('Test') {
          if (isAccountChanged == true) {

            node{

                dir('account-service'){         
               micro()
                }
            }

            }

          if (isCustomerChanged == true) {

            node{

                    dir('customer-service'){
 
                 micro()
               
                                            }

            }
            
            }

    }
node {
    stage('deploy staging') {

           

     //           rancherCli.inside {
       //             try {
                        // remove the old rancher stack in case it exists, if not ignore all errors
         //               sh 'cd docker && rancher rm demo-webshop-staging'
           //         } catch (any) {}
             //   }
       //         rancherCli.inside {
                    // now deploy the new stack
                    sh 'rancher-compose --url http://192.168.56.101:8080/v1/projects/1a5 --access-key 126F12D08951CE0554F2 --secret-key Ps1tpHbUmJ93LZ2avGQgrXGUJLgqqn86CMd3V56h up'
         //       }
            
    }
   
}
    

