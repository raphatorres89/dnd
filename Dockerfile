# 1. ESTÁGIO DE BUILD (Compilação)
# Usamos a imagem OpenJDK com o JDK 21
FROM openjdk:21-jdk-slim AS build
WORKDIR /app

# Copia os arquivos necessários para o build do Gradle:
# O wrapper (gradlew), a pasta wrapper (gradle) e os arquivos de configuração
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
# Copia o código-fonte da aplicação
COPY src src

# Garante que o script wrapper seja executável
RUN chmod +x gradlew

# Executa o build. O 'bootJar' é a tarefa padrão do Spring Boot com Gradle.
# Isso gera o JAR executável na pasta 'build/libs'.
RUN ./gradlew bootJar -x test

# 2. ESTÁGIO DE EXECUÇÃO (Runtime)
# Reutilizamos a mesma imagem leve que funcionou no seu Dockerfile antigo
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia o arquivo JAR gerado pelo Gradle.
# O caminho para o artefato do Gradle é 'build/libs/'.
# O comando 'bootJar' geralmente cria um arquivo com o nome do seu projeto e a versão.
# Usamos o curinga (*.jar) para garantir que funcione.
COPY --from=build /app/build/libs/*.jar app.jar

# Define a porta que a aplicação Spring Boot está usando
EXPOSE 8080

# Inicia a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]