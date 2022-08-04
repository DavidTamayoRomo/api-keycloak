FROM openjdk:11
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY login-keycloak/login-keycloak-1.0.jar loginkeycloak.jar
EXPOSE 8084
ENTRYPOINT exec java $JAVA_OPTS -jar loginkeycloak.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar loginkeycloak.jar
