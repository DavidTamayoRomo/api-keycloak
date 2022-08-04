package gob.mdmq.api.keycloak.consultarciu.proxy;

import gob.mdmq.api.keycloak.consultarciu.models.response.CiudadanoResponse;
import gob.mdmq.api.keycloak.consultarciu.services.CiudadanoService;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ResourceServerProxy {

  @Autowired
  private CiudadanoService service;

  public Mono<CiudadanoResponse> consultarCiudadano(String cedula) {
    try {
      return service.consultarCiudadano(cedula);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<CiudadanoResponse> sincronizarCiudadano(String cedula) {
    try {
      return service.sincronizarCiudadano(cedula);

    } catch (Throwable e) {
      return Mono.error(e);
    }
  }

  public Mono<CiudadanoResponse> consultarSincronizarCiudadano(String cedula) {
    try {
      return service.consultarSincronizarCiudadano(cedula);
    } catch (Throwable e) {
      return Mono.error(e);
    }
  }
}
