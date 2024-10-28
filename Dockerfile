FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/homeoffice-0.0.1-SNAPSHOT.jar /app/homeofficeapp.jar
COPY application.properties /app/config/application.properties
# RUN apt-get update && apt-get install -y default-mysql-client
# Update the system and install Python and pip
RUN apt-get update && \
    apt-get install -y default-mysql-client python3 python3-venv


# Create a Python virtual environment and install packages within it
RUN python3 -m venv /opt/venv && \
    /opt/venv/bin/pip install --upgrade pip && \
    /opt/venv/bin/pip install sqlalchemy pymysql

# Set the virtual environment as the default Python environment
ENV PATH="/opt/venv/bin:$PATH"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/homeofficeapp.jar", "--spring.config.location=file:/app/config/application.properties"]
