
package gob.mdmq.api.keycloak.consultarciu.controller;

import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gob.mdmq.api.keycloak.consultarciu.models.dto.CedulaDto;
import gob.mdmq.api.keycloak.consultarciu.models.response.CiudadanoResponse;
import gob.mdmq.api.keycloak.consultarciu.proxy.ResourceServerProxy;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class CiudadanoController {

  private final ResourceServerProxy proxy;

  Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

  public CiudadanoController(ResourceServerProxy proxy) {
    this.proxy = proxy;
  }

  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  @PostMapping(path = "/consultar", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<CiudadanoResponse> consultarCiu(@RequestBody CedulaDto cedula) {
    return proxy.consultarCiudadano(cedula.getCedula());
  }

  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  @PostMapping(path = "/sincronizar", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<CiudadanoResponse> sincronizarCiu(@RequestBody CedulaDto cedula) {
    return proxy.sincronizarCiudadano(cedula.getCedula());
  }

  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  @PostMapping(path = "/consultar-sincronizar", produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<CiudadanoResponse> consultarSincronizarCiu(@RequestBody CedulaDto cedula) {
    return proxy.consultarSincronizarCiudadano(cedula.getCedula());
  }
}
