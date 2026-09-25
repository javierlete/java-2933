FROM openjdk:17-jdk-alpine
LABEL authors="Franco"
WORKDIR /app
COPY target/prueba-turismo-java-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "app.jar"]
