package gob.mdmq.api.keycloak.gestionarusuariosmunicipales.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@lombok.Setter
@lombok.Getter
@Component
public class ProjectProperties {

    @Value("${spring.security.oauth2.client.provider.municipalesRealm.token-uri}")
    private String token_uri_registro;

    @Value("${spring.security.oauth2.client.registration.municipalesRealm.client-id}")
    private String client_id_registro;

    @Value("${spring.security.oauth2.client.registration.municipalesRealm.client-secret}")
    String client_secret_registro;

    @Value("${spring.security.oauth2.client.registration.municipalesRealm.authorization-grant-type}")
    String authorizationGrantType_registro;

    @Value("${resource.server.urlUsers}")
    private String resourceServerURLUsers;

}
