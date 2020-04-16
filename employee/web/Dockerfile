FROM openjdk:8-jdk-alpine

WORKDIR '/app'

COPY target/*exec.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]