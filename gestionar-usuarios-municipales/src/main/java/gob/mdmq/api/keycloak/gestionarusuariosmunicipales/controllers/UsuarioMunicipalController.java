package gob.mdmq.api.keycloak.gestionarusuariosmunicipales.controllers;

import gob.mdmq.api.keycloak.gestionarusuariosmunicipales.models.Role;
import gob.mdmq.api.keycloak.gestionarusuariosmunicipales.models.dto.CiudadanoDto;
import gob.mdmq.api.keycloak.gestionarusuariosmunicipales.models.dto.UsuarioDto;
import gob.mdmq.api.keycloak.gestionarusuariosmunicipales.proxy.ResourceServerProxy;
import reactor.core.publisher.Mono;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/municipales")
public class UsuarioMunicipalController {

  private final ResourceServerProxy proxy;

  Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

  public UsuarioMunicipalController(ResourceServerProxy proxy) {
    this.proxy = proxy;
  }

  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  @PostMapping(path = "/register-user", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<?>> usuarioInsert(@RequestBody CiudadanoDto usuario) {
    return proxy.registrarUsuario(usuario);
  }

  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  @GetMapping(path = "/list-users", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Object[]> consultarUsuarios() {
    return proxy.consultarUsuarios();
  }

  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  @GetMapping(path = "/get-user/username", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Object[]> consultarUsuarioPorUsername(@RequestParam String username) {
    return proxy.consultarUsuarioPorUsername(username);
  }

  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  @GetMapping(path = "/get-user/firstName", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Object[]> consultarUsuarioPorNombre(@RequestParam String firstName) {
    return proxy.consultarUsuarioPorNombre(firstName);
  }

  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  @GetMapping(path = "/get-user/lastName", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Object[]> consultarUsuarioPorApellidos(@RequestParam String lastName) {
    return proxy.consultarUsuarioPorApellidos(lastName);
  }

  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  @GetMapping(path = "/list-roles", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<Object[]> consultarRolesClient(@RequestParam String client_id) {
    return proxy.consultarRolesCliente(client_id);
  }

  @ResponseBody
  @PostMapping(path = "/client/user/add-role-mapping", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<?>> addRolClientUser(@RequestParam String user_id, @RequestParam String client_id,
      @RequestBody Role[] roles) {
    return proxy.addRolClientUser(user_id, client_id, roles);
  }

  @ResponseBody
  @DeleteMapping(path = "/client/user/del-role-mapping", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<?>> delRolClientUser(@RequestParam String user_id, @RequestParam String client_id,
      @RequestBody Role[] roles) {
    return proxy.delRolClientUser(user_id, client_id, roles);
  }

  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  @PostMapping(path = "/enabled-user", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<?>> habilitarDeshabilitarUsuario(@RequestBody UsuarioDto usuario) {
    return proxy.habilitarDeshabilitarUsuario(usuario.getUser_id(),
        usuario.isEnabled() ? true : false);
  }
}
