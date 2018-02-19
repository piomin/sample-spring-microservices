 using hostname.

[code language="java"]
node {

        stage('Checkout') {
            git url: 'https://github.com/piomin/sample-spring-microservices.git', credentialsId: 'github-piomin', branch: 'master'
}
    withMaven(maven:'maven') {
        stage ('Final') {
            build job: 'customer-service-pipeline', wait: false
        }      

    }

}
