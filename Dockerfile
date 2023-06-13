FROM amazoncorretto:11
COPY target/primerproyecto-0.0.1-SNAPSHOT.jar primerproyecto-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "primerproyecto-0.0.1-SNAPSHOT.jar"]