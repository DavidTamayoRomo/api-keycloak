package gob.mdmq.api.keycloak.gestionarusuariosmunicipales.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDto {

    private String user_id;
    private boolean enabled;

    public UsuarioDto() {
    }
}
