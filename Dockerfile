FROM openjdk:11
EXPOSE 8082
ADD target/timesheet-1.0-SNAPSHOT.jar timesheet-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/timesheet-1.0-SNAPSHOT.jar"]