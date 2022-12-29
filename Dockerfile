FROM openjdk:8-jdk-alpine
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} managementAPI.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/managementAPI.jar"]