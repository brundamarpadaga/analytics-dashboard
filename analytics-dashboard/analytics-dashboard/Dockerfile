FROM openjdk:17-alpine

EXPOSE 8080

COPY target/analytics-dashboard-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java","-jar","/app.jar" ]