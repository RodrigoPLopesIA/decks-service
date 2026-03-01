# Estágio 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copia apenas os arquivos de configuração primeiro (otimiza cache do Docker)
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Baixa as dependências (cache layer)
RUN mvn dependency:go-offline -B

# Copia o código fonte
COPY src src

# Compila e empacota a aplicação
RUN mvn clean package -DskipTests

# Estágio 2: Imagem final mais leve
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Cria um usuário não-root para segurança
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copia o JAR do estágio de build
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8082

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]