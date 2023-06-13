FROM openjdk:11-jdk-slim
COPY --from=build target/primerproyecto-0.0.1-SNAPSHOT.jar primerproyecto.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "primerproyecto.jar"]