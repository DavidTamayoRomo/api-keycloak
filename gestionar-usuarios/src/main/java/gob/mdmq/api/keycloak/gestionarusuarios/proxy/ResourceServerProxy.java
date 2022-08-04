package gob.mdmq.api.keycloak.gestionarusuarios.proxy;

import gob.mdmq.api.keycloak.gestionarusuarios.models.Role;
import gob.mdmq.api.keycloak.gestionarusuarios.models.dto.CiudadanoDto;
import gob.mdmq.api.keycloak.gestionarusuarios.models.dto.CredencialDto;
import gob.mdmq.api.keycloak.gestionarusuarios.services.UsuarioService;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResourceServerProxy {

  @Autowired
  private UsuarioService service;

  public Mono<ResponseEntity<?>> registrarUsuario(CiudadanoDto usuario) {
    try {
      return service.registrarUsuario(usuario);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<ResponseEntity<?>> consultarUsuarioResetPassword(CredencialDto credenciales, String username) {
    try {
      return service.consultarUsuarioResetPassword(credenciales, username);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<ResponseEntity<?>> habilitarDeshabilitarUsuario(String user_id, boolean enabled) {
    try {

      return service.habilitarDeshabilitarUsuario(user_id, enabled);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<Object[]> consultarUsuarioPorUserName(String username) {
    try {
      return service.consultarUsuarioPorUserName(username);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<Object[]> consultarUsuarioPorNombres(String firstName) {
    try {
      return service.consultarUsuarioPorNombres(firstName);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<Object[]> consultarUsuarioPorApellidos(String lastName) {
    try {
      return service.consultarUsuarioPorApellidos(lastName);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<Object[]> consultarRolesCliente(String client_id) {
    try {
      return service.consultarRolesCliente(client_id);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<ResponseEntity<?>> addRolClientUser(String user_id, String client_id, Role[] roles) {
    try {
      return service.addRolClientUser(user_id, client_id, roles);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<ResponseEntity<?>> delRolClientUser(String user_id, String client_id, Role[] roles) {
    try {
      return service.delRolClientUser(user_id, client_id, roles);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

}
