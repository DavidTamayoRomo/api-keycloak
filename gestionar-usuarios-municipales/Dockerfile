FROM openjdk:11
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY gestionar-usuarios-municipales/gestionar-usuarios-municipales-1.0.jar gestionarusuariosmunicipales.jar
EXPOSE 8085
ENTRYPOINT exec java $JAVA_OPTS -jar gestionarusuariosmunicipales.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar gestionarusuarios.jar
