FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR  /app
COPY . .
RUN mvn clean install
ENTRYPOINT ["mvn", "-e", "spring-boot:run","-pl","./application/configuration"]