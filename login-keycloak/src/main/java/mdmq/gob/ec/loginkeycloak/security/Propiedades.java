package mdmq.gob.ec.loginkeycloak.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@lombok.Setter
@lombok.Getter
@Component
public class Propiedades {

    @Value("${login.token.url}")
    String base_uri;
}