FROM amazoncorretto:11-alpine-jdk
MAINTAINER ESG // quien es el dueño de la imagen
COPY target/primerproyecto-0.0.1-SNAPSHOT.jar esg-app.jar  // va a copiar de nuestro proyecto el empaquetado y lo va a subir a github/
ENTRYPOINT ["java", "-jar", "/esg-app.jar"]   // es la instruccion que se va a ejecutar primero