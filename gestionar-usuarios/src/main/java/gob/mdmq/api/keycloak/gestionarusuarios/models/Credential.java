package gob.mdmq.api.keycloak.gestionarusuarios.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Credential {
    private String type = "password";
    private String value;
    private boolean temporary = false;

    public Credential() {
    }

}
