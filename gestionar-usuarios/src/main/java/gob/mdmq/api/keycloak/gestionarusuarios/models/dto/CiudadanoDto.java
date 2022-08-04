package gob.mdmq.api.keycloak.gestionarusuarios.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import gob.mdmq.api.keycloak.gestionarusuarios.models.Access;
import gob.mdmq.api.keycloak.gestionarusuarios.models.Atribute;
import gob.mdmq.api.keycloak.gestionarusuarios.models.Credential;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CiudadanoDto {

    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled = true;
    private boolean totp = false;
    private String username;
    private String[] requiredActions = {};
    private int notBefore = 0;
    private Atribute attributes;
    private Credential[] credentials;
    private Access access;

    public CiudadanoDto() {
    }
}
