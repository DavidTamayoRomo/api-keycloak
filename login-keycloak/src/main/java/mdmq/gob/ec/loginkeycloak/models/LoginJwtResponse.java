package mdmq.gob.ec.loginkeycloak.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginJwtResponse {

    private String access_token;

    private String expires_in;

    private String refresh_expires_in;

    private String refresh_token;

    private String token_type;

    private String session_state;

    private String scope;
}
