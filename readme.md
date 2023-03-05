# Microservices with Spring Cloud Demo Project [![Twitter](https://img.shields.io/twitter/follow/piotr_minkowski.svg?style=social&logo=twitter&label=Follow%20Me)](https://twitter.com/piotr_minkowski)

In this project I'm demonstrating you the most interesting features of [Spring Cloud Project](https://spring.io/projects/spring-cloud) for building microservice-based architecture. Most of examples are based on **Spring Boot 1.5**.

> :warning: This repository contains examples of Spring Boot 1.5 and won't be updated. **If you are looking for the repository with the latest versions of Spring Boot/Spring Cloud please refer to that: https://github.com/piomin/sample-spring-microservices-new**. It is automatically updated to the latest versions of all frameworks and libraries.

## Getting Started 
Currently you may find here some examples of microservices implementation using different projects from Spring Cloud. All the examples are divided into the branches and described in a separated articles on my blog. Here's a full list of available examples:
1. Introduction to Spring Cloud components like discovery with **Eureka**, load balancing with **Ribbon**, REST client **Feign**, API gataway with **Zuul**. The example is available in the branch [master](https://github.com/piomin/sample-spring-microservices/tree/master). A detailed description can be found here: [Part 1: Creating microservice using Spring Cloud, Eureka and Zuul](https://piotrminkowski.com/2017/02/05/part-1-creating-microservice-using-spring-cloud-eureka-and-zuul/)
2. Introduction to Spring Cloud components used for microservices monitoring like **Spring Cloud Sleuth** and **Zipkin**. Integration with **Logstash** for sending logs to ELK. The example is available in the branch [logstash](https://github.com/piomin/sample-spring-microservices/tree/logstash). A detailed description can be found here: [Part 2: Creating microservices – monitoring with Spring Cloud Sleuth, ELK and Zipkin](https://piotrminkowski.com/2017/04/05/part-2-creating-microservices-monitoring-with-spring-cloud-sleuth-elk-and-zipkin/)
3. Introduction to load balancing with **Ribbon** and **Feign** declarative HTTP client, circuit braker and fallback with **Hystrix**. The example is available in the branch [hystrix](https://github.com/piomin/sample-spring-microservices/tree/hystrix). A detailed description can be found here: [Part 3: Creating Microservices: Circuit Breaker, Fallback and Load Balancing with Spring Cloud](https://piotrminkowski.com/2017/05/15/part-3-creating-microservices-circuit-breaker-fallback-and-load-balancing-with-spring-cloud/)
4. Using tool **Spring Boot Admin** for managing and monitoring microservices-based system. The example is available in the branch [admin](https://github.com/piomin/sample-spring-microservices/tree/admin). A detailed description can be found here: [Monitoring Microservices With Spring Boot Admin](https://piotrminkowski.com/2017/06/26/monitoring-microservices-with-spring-boot-admin/)
5. Deploying and running Spring Boot microservices on **Kubernetes** including inter-service communication using **Feign** client and integration with database **Mongo**. The example is available in the branch [kubernetes](https://github.com/piomin/sample-spring-microservices/tree/kubernetes). A detailed description can be found here: [Microservices with Kubernetes and Docker](https://piotrminkowski.com/2017/03/31/microservices-with-kubernetes-and-docker) 


### Usage

In the most cases you need to have Maven, JDK8+ and Docker for running third-party software like Zipkin or Logstash. In the fifth example with Kubernetes you will have to run **Minikube** on your local machine. The best way to run the sample applications is with IDEs like IntelliJ IDEA or Eclipse.  

### How to Run

docker-compose up

If you want to change anything on any service(s), you need to build the service(s) you changed and then :

docker-compose build
docker-compose up

### How to Run

docker-compose down

## Architecture

Our sample microservices-based system consists of the following modules:
- **gateway-service** - a module that Spring Cloud Netflix Zuul for running Spring Boot application that acts as a proxy/gateway in our architecture.
- **config-service** - a module that uses Spring Cloud Config Server for running configuration server in the `native` mode. The configuration files are placed on the classpath.
- **discovery-service** - a module that depending on the example it uses Spring Cloud Netflix Eureka as an embedded discovery server.
- **account-service** - a module containing the first of our sample microservices that allows to perform CRUD operation on in-memory repository of accounts
- **customer-service** - a module containing the second of our sample microservices that allows to perform CRUD operation on in-memory repository of customers. It communicates with account-service. 
- **zipkin-service** - a module that runs embedded Zipkin instance.

The following picture illustrates the architecture described above.

<img src="https://piotrminkowski.files.wordpress.com/2017/02/san1s57hfsas5v53ms53.png" title="Architecture"/><br/>

In case of Kubernetes deployment we use only some of Spring Cloud components like Spring Cloud **Feign** or **Sleuth** without discovery or config server.

<img src="https://piotrminkowski.files.wordpress.com/2017/03/kube_micro.png?w=768&h=528" title="Kube"/>

For similar examples of microservice applications with Spring Boot 2 you may refer to the repository https://github.com/piomin/sample-spring-microservices-new
