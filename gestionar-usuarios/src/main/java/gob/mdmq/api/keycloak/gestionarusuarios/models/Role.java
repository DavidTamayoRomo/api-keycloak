package gob.mdmq.api.keycloak.gestionarusuarios.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    private String id;
    private String name;
    private boolean composite = false;
    private boolean clientRole = true;
    private String containerId;

    public Role() {
    }
}
