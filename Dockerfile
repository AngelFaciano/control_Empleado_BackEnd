FROM amazoncorretto:17.0.0-alpine
MAINTAINER faf
COPY target/gestion.empleado-0.0.1-SNAPSHOT.jar faf-app.jar
ENTRYPOINT ["java","-jar","/faf-app.jar"]
