package gob.mdmq.api.keycloak.gestionarusuariosmunicipales.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Setter
@lombok.Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Access {
    private boolean manageGroupMembership = true;
    private boolean view = true;
    private boolean mapRoles = true;
    private boolean impersonate = true;
    private boolean manage = true;

    public Access() {
    }
}
