FROM azul/zulu-openjdk-alpine:11
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
MAINTAINER Ramazan Sakin <ramazansakin63@gmail.com>
ADD target/gateway-service.jar gateway-service.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "/gateway-service.jar"]
