# FROM openjdk:11
# VOLUME /tmp
# ARG JAVA_OPTS
# ENV JAVA_OPTS=$JAVA_OPTS
# COPY gestionar-usuarios/gestionar-usuarios-1.0.jar gestionarusuarios.jar
# EXPOSE 8082
# ENTRYPOINT exec java $JAVA_OPTS -jar gestionarusuarios.jar
# # For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
# #ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar gestionarusuarios.jar


## Dockerfile-provider

# Maven 
FROM maven:3.8.1-openjdk-11-slim AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn -e -B dependency:resolve

COPY src ./src

RUN mvn clean -e -B package


# RTSDK Java
FROM openjdk:11

WORKDIR /app

ENV TZ=America/Guayaquil
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

COPY --from=builder /app/target/gestionar-usuarios-1.0.jar .

EXPOSE 8082

CMD ["java", "-jar", "./gestionar-usuarios-1.0.jar"]