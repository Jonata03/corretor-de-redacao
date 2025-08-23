FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests -pl corretor-redacao-api-application -am

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/corretor-redacao-api-application/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]