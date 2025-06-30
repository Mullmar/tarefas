# Etapa 1: build da aplicação com Gradle, ignorando testes
FROM gradle:8.5-jdk17 AS builder
COPY . /app
WORKDIR /app
RUN gradle build -x test --no-daemon

# Etapa 2: imagem final com JAR pronto
FROM eclipse-temurin:17-jdk-alpine
COPY --from=builder /app/build/libs/tarefas-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]