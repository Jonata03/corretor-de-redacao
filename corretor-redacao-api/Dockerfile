FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests -pl corretor-redacao-api-application -am

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/corretor-redacao-api-application/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]