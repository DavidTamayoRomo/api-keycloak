
package gob.mdmq.api.keycloak.consultarciu.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cedula {
    
        private String numero;
        private String fechaExpedicionCedula;
        private String fechaExpiracionCedula;
        private String codigoDactilar; 
    public Cedula()
    {}
}
