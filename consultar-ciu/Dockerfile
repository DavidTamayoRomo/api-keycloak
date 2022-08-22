## Dockerfile-provider

# Maven 
FROM maven:3.8.1-openjdk-11-slim AS builder

WORKDIR /app/consultar-ciu

COPY consultar-ciu/pom.xml .

RUN mvn -e -B dependency:resolve

COPY consultar-ciu/src ./src

RUN mvn clean -e -B package


# RTSDK Java
FROM openjdk:11

WORKDIR /app

ENV TZ=America/Guayaquil
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=builder /app/consultar-ciu/target/consultar-ciu-1.0.jar .

EXPOSE 8081

CMD ["java", "-jar", "./consultar-ciu-1.0.jar"]
