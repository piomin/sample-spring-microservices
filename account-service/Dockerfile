FROM openjdk
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/account-service-1.0-SNAPSHOT.jar account-service.jar
ENV DISCOVERY_URL=http://127.0.0.1:8761
ENTRYPOINT ["java", "-DDISCOVERY_URL=${DISCOVERY_URL} -jar", "/account-service.jar"]
EXPOSE 2222