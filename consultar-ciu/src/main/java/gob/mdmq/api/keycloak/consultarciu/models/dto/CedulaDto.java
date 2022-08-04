
package gob.mdmq.api.keycloak.consultarciu.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CedulaDto {

    private String cedula;

    public CedulaDto() {
    }
}
