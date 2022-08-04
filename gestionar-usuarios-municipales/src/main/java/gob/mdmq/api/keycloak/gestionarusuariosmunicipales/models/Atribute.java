package gob.mdmq.api.keycloak.gestionarusuariosmunicipales.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Atribute {
    private String[] cedula;
    private String[] telefono;
    private String[] locale;

    public Atribute() {
    }
}
