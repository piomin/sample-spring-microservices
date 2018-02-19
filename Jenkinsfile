node {
        stage ('Final') {
            steps {
                echo "hello ${env.WORKSPACE}"
                sh "ls ${env.WORKSPACE}"
                build job: "${env.WORKSPACE}/account-service/Jenkinsfile"
                   }
        }      
}
