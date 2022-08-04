package gob.mdmq.api.keycloak.consultarciu.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@lombok.Setter
@lombok.Getter
@Component
public class ProjectProperties {

    @Value("${spring.security.oauth2.client.provider.appCiudadanos.token-uri}")
    String token_uri;

    @Value("${spring.security.oauth2.client.registration.appCiudadanos.client-id}")
    String client_id;

    @Value("${spring.security.oauth2.client.registration.appCiudadanos.client-secret}")
    String client_secret;

    @Value("${spring.security.oauth2.client.registration.appCiudadanos.scope}")
    String scope;

    @Value("${spring.security.oauth2.client.registration.appCiudadanos.authorization-grant-type}")
    String authorizationGrantType;

    @Value("${resource.server.url}")
    private String resourceServerURL;

}
