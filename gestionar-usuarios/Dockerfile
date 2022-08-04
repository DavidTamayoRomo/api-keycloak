FROM openjdk:11
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY gestionar-usuarios/gestionar-usuarios-1.0.jar gestionarusuarios.jar
EXPOSE 8082
ENTRYPOINT exec java $JAVA_OPTS -jar gestionarusuarios.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar gestionarusuarios.jar
