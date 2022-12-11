## Dockerfile-provider

# Maven 
FROM maven:3.8.1-openjdk-11-slim AS builder

WORKDIR /app/gestionar-usuarios-municipales

COPY gestionar-usuarios-municipales/pom.xml .

RUN mvn -e -B dependency:resolve

COPY gestionar-usuarios-municipales/src ./src

RUN mvn clean -e -B package


# RTSDK Java
FROM openjdk:11

COPY ./certs/tls.crt /etc/ssl/certs/

RUN keytool -import -alias certificado-keycloack -keystore $JAVA_HOME/lib/security/cacerts -file /etc/ssl/certs/tls.crt -noprompt -trustcacerts -storepass changeit

WORKDIR /app

ENV TZ=America/Guayaquil
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=builder /app/gestionar-usuarios-municipales/target/gestionar-usuarios-municipales-1.0.jar .

EXPOSE 8085

CMD ["java", "-jar", "./gestionar-usuarios-municipales-1.0.jar"]
