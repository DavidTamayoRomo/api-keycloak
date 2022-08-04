package gob.mdmq.api.keycloak.gestionarusuarios.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@lombok.Setter
@lombok.Getter
@Component
public class ProjectProperties {

    @Value("${spring.security.oauth2.client.provider.ciudadanosRealm.token-uri}")
    private String token_uri_registro;

    @Value("${spring.security.oauth2.client.registration.ciudadanosRealm.client-id}")
    private String client_id_registro;

    @Value("${spring.security.oauth2.client.registration.ciudadanosRealm.client-secret}")
    String client_secret_registro;

    @Value("${spring.security.oauth2.client.registration.ciudadanosRealm.authorization-grant-type}")
    String authorizationGrantType_registro;

    @Value("${resource.server.urlUsers}")
    private String resourceServerURLUsers;

}
