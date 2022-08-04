package gob.mdmq.api.keycloak.gestionarusuariosmunicipales.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CredencialDto {

    private String type = "password";
    private String value;
    private boolean temporary = false;

    public CredencialDto() {
    }
}
