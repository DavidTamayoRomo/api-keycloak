package gob.mdmq.api.keycloak.consultarciu.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import gob.mdmq.api.keycloak.consultarciu.models.Cedula;
import gob.mdmq.api.keycloak.consultarciu.models.Discapacidad;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CiudadanoResponse {

    private Discapacidad discapacidad;

    private Cedula cedula;

    private String numeroIdentificacion;

    private String apellidosNombres;

    private String nombres;

    private String apellidos;

    private String condicionCiudadano;

    private String fechaNacimiento;

    private String fechaSincronizacion;

    private String estado;

    private String fechaCreacion;

    public CiudadanoResponse() {
    }
}
