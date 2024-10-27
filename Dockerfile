FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/homeoffice-0.0.1-SNAPSHOT.jar /app/homeofficeapp.jar
COPY application.properties /app/config/application.properties
RUN apt-get update && apt-get install -y mysql-client
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/homeofficeapp.jar", "--spring.config.location=file:/app/config/application.properties"]
