FROM 101.200.216.3:80/micro-service/openjdk:7-jre
MAINTAINER xxx xxx@imooc.com

COPY ./target/user-edge-service-1.0-SNAPSHOT.jar /user-edge-service.jar

ENTRYPOINT ["java", "-jar", "/user-edge-service.jar"]