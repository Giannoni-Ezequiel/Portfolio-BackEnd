FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17
COPY --from=build /target/primerproyecto-0.0.1-SNAPSHOT.jar primerproyecto-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "primerproyecto-0.0.1-SNAPSHOT.jar"]