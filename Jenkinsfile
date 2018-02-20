#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Check for CHANGELOG update') {
            when { expression { env.BRANCH_NAME != 'master' } }
            steps {
                script {
                    sshagent(['97:8c:1b:f2:6f:14:6b:5c:3b:ec:aa:46:46:74:7c:40']) {
                        sh "git config --add remote.origin.fetch +refs/heads/trunk:refs/remotes/origin/trunk"
                        sh "git fetch --no-tags"
                        List<String> sourceChanged = sh(returnStdout: true, script: "git diff --name-only origin/trunk..origin/${env.BRANCH_NAME}").split()
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
