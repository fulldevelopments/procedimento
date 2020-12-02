FROM maven:3.5.2-jdk-8-alpine AS maven_build

COPY pom.xml /tmp/

COPY src /tmp/src/

WORKDIR /tmp/

RUN mvn package

FROM openjdk:8-jdk-alpine

MAINTAINER "USUARIO DOCKER"

EXPOSE 8080

CMD java -jar /data/procedimento-0.1.0.jar

COPY --from=maven_build /tmp/target/procedimento-0.1.0.jar /data/procedimento-0.1.0.jar
