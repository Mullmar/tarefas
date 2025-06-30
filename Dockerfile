FROM gradle:8.5-jdk17 AS builder
COPY . /app
WORKDIR /app
RUN gradle build --no-daemon

FROM eclipse-temurin:17-jdk-alpine
COPY --from=builder /app/build/libs/tarefas-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]