FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/devops.war devops.war
ENTRYPOINT ["java","-jar","/devops.war"]
