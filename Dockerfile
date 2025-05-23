# Etapa 1: Build do aplicativo
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Cria e entra na pasta de trabalho
WORKDIR /app

# Copia apenas arquivos necessários primeiro (aproveita cache de dependências)
COPY pom.xml .
COPY src ./src

# Realiza o build do projeto sem os testes
RUN mvn clean package -DskipTests

# Etapa 2: Runtime do aplicativo
FROM eclipse-temurin:17

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado para o container final
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta usada pelo app
EXPOSE 8080

# Define o comando de execução
ENTRYPOINT ["java", "-jar", "app.jar"]