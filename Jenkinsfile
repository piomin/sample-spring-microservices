#!/usr/bin/env groovy
pipeline {
    agent any
    stages {     
        stage('Check for CHANGELOG update') {
            when { expression { env.BRANCH_NAME != 'master' } }
            steps {
                script {
                    sshagent(['Credential Name']) {
                        sh "git config --add remote.origin.fetch +refs/heads/master:refs/remotes/origin/master"
                        sh "git fetch --no-tags"
                        List<String> sourceChanged = sh(returnStdout: true, script: "git diff --name-only origin/master..origin/${env.BRANCH_NAME}").split()
                        def isAccountChanged = false
                        def isCustomerChanged = false
                        def isDiscoveryChanged = false
                        def isGatewayChanged = false
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
                        if (isAccountChanged == true) {
                            echo "** Entities changed ***"
                            

                            stage ('Run') {
                                docker.image("localhost:5000/account-service:${env.version}").run('-p 2222:2222 -h account --name account --link discovery')
                            }




                        }
                        if (isCustomerChanged == true) {
                            echo "** scheduler changed ***"
                        }
                    }
                }
            }
        }
    }
}
