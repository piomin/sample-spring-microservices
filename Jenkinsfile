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
       
 stage('Test') {

    parallel (
        "account": {

          if (isAccountChanged == true) {

            node{
                    dir('account-service'){
            stage('checkout') {

                sh "chmod +x script.sh"
                sh "./script.sh "
                   
            }
            stage('scrip') {

                sh "chmod +x scrip.sh"
                sh "./scrip.sh "
                   
            }
                                }
            }

            }

        },
        "Customer": {

          if (isCustomerChanged == true) {

            node{
                    dir('customer-service'){
            stage('checkout') {


                sh "chmod +x script.sh"
                sh "./script.sh "

            }
            stage('scrip') {


                sh "chmod +x scrip.sh"
                sh "./scrip.sh "

            }
                    }

            }

            }

        }
        )
    }

