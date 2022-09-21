## Dockerfile-provider

# Maven 
FROM maven:3.8.1-openjdk-11-slim AS builder

WORKDIR /app/login-keycloak

COPY login-keycloak/pom.xml .

RUN mvn -e -B dependency:resolve

COPY login-keycloak/src ./src

RUN mvn clean -e -B package


# RTSDK Java
FROM openjdk:11

WORKDIR /app

ENV TZ=America/Guayaquil
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=builder /app/login-keycloak/target/login-keycloak-1.0.jar .

EXPOSE 8084

CMD ["java", "-jar", "./login-keycloak-1.0.jar"]