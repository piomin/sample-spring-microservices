FROM azul/zulu-openjdk-alpine:11
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
MAINTAINER Ramazan Sakin <ramazansakin63@gmail.com>
ADD target/customer-service.jar customer-service.jar
EXPOSE 3333
ENTRYPOINT ["java", "-jar", "/customer-service.jar"]
