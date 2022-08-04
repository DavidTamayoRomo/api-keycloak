package gob.mdmq.api.keycloak.consultarciu.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import gob.mdmq.api.keycloak.consultarciu.models.response.CiudadanoResponse;
import gob.mdmq.api.keycloak.consultarciu.security.ProjectProperties;
import reactor.core.publisher.Mono;

@Service
public class CiudadanoService {

    Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

    @Autowired
    private ProjectProperties prop;

    @Autowired
    private WebClient webClient;

    public Mono<CiudadanoResponse> consultarCiudadano(String cedula) {
        try {
            String url = prop.getResourceServerURL() + "/consultar/" + cedula;

            Mono<CiudadanoResponse> retrievedResource = webClient.get()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("appCiudadanos"))
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.OK)) {
                            return response.bodyToMono(CiudadanoResponse.class);
                        } else {
                            return response.createException()
                                    .flatMap(Mono::error);
                        }
                    }).cast(CiudadanoResponse.class);

            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<CiudadanoResponse> sincronizarCiudadano(String cedula) {
        try {
            String url = prop.getResourceServerURL() + "/sincronizar/" + cedula;

            Mono<CiudadanoResponse> retrievedResource = webClient.get()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("appCiudadanos"))
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.OK)) {
                            return response.bodyToMono(CiudadanoResponse.class);
                        } else {
                            return response.createException()
                                    .flatMap(Mono::error);
                        }
                    }).cast(CiudadanoResponse.class);

            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<CiudadanoResponse> consultarSincronizarCiudadano(String cedula) {
        try {
            String url = prop.getResourceServerURL() + "/consultar/" + cedula;

            Mono<CiudadanoResponse> retrievedResource = webClient.get()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("appCiudadanos"))
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.OK)) {
                            return response.bodyToMono(CiudadanoResponse.class);
                        } else {
                            return response.createException()
                                    .flatMap(Mono::error);
                        }
                    });

            CiudadanoResponse resp = retrievedResource.block();

            if (resp.getEstado().equals("NO_ENCONTRADO")) {
                Mono<CiudadanoResponse> mono = sincronizarCiudadano(cedula);
                return mono;
            } else {
                return retrievedResource;
            }

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }
}
