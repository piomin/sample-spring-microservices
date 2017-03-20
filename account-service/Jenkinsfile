 using hostname.

[code language="java"]
node {

    withMaven(maven:'maven') {

        stage('Checkout') {
            git url: 'https://github.com/piomin/sample-spring-microservices.git', credentialsId: 'github-piomin', branch: 'master'
        }

        stage('Build') {
            sh 'mvn clean install'

            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
        }

        stage('Image') {
            dir ('account-service') {
                def app = docker.build "localhost:5000/account-service:${env.version}"
                app.push()
            }
        }

        stage ('Run') {
            docker.image("localhost:5000/account-service:${env.version}").run('-p 2222:2222 -h account --name account --link discovery')
        }

        stage ('Final') {
            build job: 'customer-service-pipeline', wait: false
        }      

    }

}