package gob.mdmq.api.keycloak.consultarciu.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "resource.server")
public class ServerProperties {
    private String url;
}
