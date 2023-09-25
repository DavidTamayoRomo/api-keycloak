package gob.mdmq.api.keycloak.gestionarusuariosmunicipales.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CredencialDto {

    private String type;
    private String value;
    private boolean temporary;

    public CredencialDto(String type, String value, boolean temporary) {
        this.type = type;
        this.value = value;
        this.temporary = temporary;

    }
}
