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
                    dir('account-service'){
                sh "pwd ;chmod +x script.sh"
                sh "pwd ; ./script.sh "
                    }
            }
            stage('scrip') {
                    dir('account-service'){
                sh "pwd ;chmod +x scrip.sh"
                sh "pwd ; ./scrip.sh "
                    }
            }
           stage('checkout2') {
                    dir('account-service'){
                sh "pwd ; chmod +x script.sh"
                sh "pwd ; ./script.sh "
                    }
            }
            stage('scrip2') {
                    dir('account-service'){
                sh "pwd ; chmod +x scrip.sh"
                sh "pwd ; ./scrip.sh "
                    }
            }     
}
def micro1() {
            stage('checkout') {
                    dir('customer-service'){
                sh "pwd ;chmod +x script.sh"
                sh "pwd ; ./script.sh "
                    }
            }
            stage('scrip') {
                    dir('customer-service'){
                sh "pwd ;chmod +x scrip.sh"
                sh "pwd ; ./scrip.sh "
                    }
            }
           stage('checkout2') {
                    dir('customer-service'){
                sh "pwd ; chmod +x script.sh"
                sh "pwd ; ./script.sh "
                    }
            }
            stage('scrip2') {
                    dir('customer-service'){
                sh "pwd ; chmod +x scrip.sh"
                sh "pwd ; ./scrip.sh "
                    }
            }     
}
       
 stage('Test') {

    parallel (
        "account": {

          if (isAccountChanged == true) {

            node{

           /* stage('checkout') {

                sh "chmod +x script.sh"
                sh "./script.sh "
                   
            }
            stage('scrip') {

                sh "chmod +x scrip.sh"
                sh "./scrip.sh "
                   
            }
           stage('checkout2') {

                sh "chmod +x script.sh"
                sh "./script.sh "
                   
            }
            stage('scrip2') {

                sh "chmod +x scrip.sh"
                sh "./scrip.sh "
                   
            }
            }*/
                    
               micro()
            }

            }

        },
        "Customer": {

          if (isCustomerChanged == true) {

            node{
               /*     dir('customer-service'){
            stage('checkout') {


                sh "chmod +x script.sh"
                sh "./script.sh "

            }
            stage('scrip') {


                sh "chmod +x scrip.sh"
                sh "./scrip.sh "

            }
            stage('checkout2') {


                sh "chmod +x script.sh"
                sh "./script.sh "

            }
            stage('scrip2') {


                sh "chmod +x scrip.sh"
                sh "./scrip.sh "

            }
                               } */
                 micro1()
               
 

            }

            }

        }
        )
    }

