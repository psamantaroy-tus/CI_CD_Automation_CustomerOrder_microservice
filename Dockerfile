# syntax=docker/dockerfile:1

FROM maven:3.9.11-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml ./
COPY src ./src

# Build a runnable Spring Boot jar
RUN mvn -B clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/customer-order-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
