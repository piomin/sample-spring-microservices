FROM openjdk:8-jdk-alpine
MAINTAINER Ramazan Sakin <ramazansakin63@gmail.com>
ADD target/*.jar zipkin-service.jar
EXPOSE 9411
ENTRYPOINT ["java", "-jar", "/zipkin-service.jar"]
