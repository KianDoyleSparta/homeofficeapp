FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/homeofficeapp.jar /app/homeofficeapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/homeofficeapp.jar"]
