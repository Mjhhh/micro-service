FROM 101.200.216.3:80/micro-service/openjdk:7-jre
MAINTAINER xxx xxx@imooc.com

COPY ./target/course-dubbo-service-1.0-SNAPSHOT.jar /course-service.jar

ENTRYPOINT ["java", "-jar", "/course-service.jar"]
