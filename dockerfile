FROM adoptopenjdk/openjdk11:latest
EXPOSE 8088
ADD target/timesheet-0.0.1-SNAPSHOT.jar timesheet-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/timesheet-0.0.1-SNAPSHOT.jar" ]