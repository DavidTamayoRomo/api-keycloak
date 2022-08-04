package gob.mdmq.api.keycloak.consultarciu.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Discapacidad {

    private String predominante;
    private String codigoConadis;
    private Integer porcentaje;

    public Discapacidad()
    {}

}
