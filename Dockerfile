FROM amazoncorretto:11-alpine-jdk
MAINTAINER ESG
COPY target/primerproyecto-0.0.1-SNAPSHOT.jar esg-app.jar
ENTRYPOINT ["java", "-jar", "/esg-app.jar"]  