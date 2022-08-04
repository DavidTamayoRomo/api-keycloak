package mdmq.gob.ec.loginkeycloak.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "login.token")
public class LoginProperties {
    private String url;
}
