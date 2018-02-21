#!/usr/bin/env groovy
pipeline {
        agent any

        stages {

                stage('test3') {
                        steps {
                                script {
                                        if ( sendhipchat() == true) {
                                                echo 'sendhipchat()'
                                                echo 'account changed'
                                        } else {
                                                echo 'NO'
                                        }
                                }
                        }
                }
        }
}
def sendhipchat() {     
        script {
            if (env.BRANCH_NAME != 'master') {
                    echo 'I only execute on the master branch'
                    sshagent(['Credential Name']) {
                        sh "git config --add remote.origin.fetch +refs/heads/master:refs/remotes/origin/master"
                        sh "git fetch --no-tags"
                        List<String> sourceChanged = sh(returnStdout: true, script: "git diff --name-only origin/master..origin/${env.BRANCH_NAME}").split()
                        echo "** sourceChanged.size()***"
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
                    }
            }
        }
return isAccountChanged 
}
