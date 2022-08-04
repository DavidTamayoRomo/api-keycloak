package gob.mdmq.api.keycloak.gestionarusuarios.services;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import reactor.core.publisher.Mono;
import gob.mdmq.api.keycloak.gestionarusuarios.models.Role;
import gob.mdmq.api.keycloak.gestionarusuarios.models.dto.CiudadanoDto;
import gob.mdmq.api.keycloak.gestionarusuarios.models.dto.CredencialDto;
import gob.mdmq.api.keycloak.gestionarusuarios.security.ProjectProperties;

@Service
public class UsuarioService {

    Logger logger = LoggerFactory.getLogger(CommandLineRunner.class);

    @Autowired
    private ProjectProperties prop;

    @Autowired
    private WebClient webClient;

    public Mono<ResponseEntity<?>> registrarUsuario(CiudadanoDto usuario) {
        try {
            Mono<ResponseEntity<?>> retrievedResource = webClient.post()
                    .uri(prop.getResourceServerURLUsers() + "/users")
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("ciudadanosRealm"))
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(usuario)
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.CREATED)) {
                            return Mono.just(new ResponseEntity<Mono<?>>(HttpStatus.CREATED));
                        } else {
                            return Mono.just(new ResponseEntity<Mono<?>>(response.statusCode()));
                        }
                    });

            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<Object[]> consultarUsuarioPorUserName(String username) {

        try {
            String url = prop.getResourceServerURLUsers() + "/users?username=" + username;

            Mono<Object[]> retrievedResource = webClient.get()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("ciudadanosRealm"))
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.OK)) {
                            return response.bodyToMono(Object[].class);
                        } else {
                            return response.createException()
                                    .flatMap(Mono::error);
                        }
                    });
            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<Object[]> consultarUsuarioPorNombres(String firstName) {

        try {
            String url = prop.getResourceServerURLUsers() + "/users?firstName=" + firstName;

            Mono<Object[]> retrievedResource = webClient.get()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("ciudadanosRealm"))
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.OK)) {
                            return response.bodyToMono(Object[].class);
                        } else {
                            return response.createException()
                                    .flatMap(Mono::error);
                        }
                    });
            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<Object[]> consultarUsuarioPorApellidos(String lastName) {

        try {
            String url = prop.getResourceServerURLUsers() + "/users?lastName=" + lastName;

            Mono<Object[]> retrievedResource = webClient.get()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("ciudadanosRealm"))
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.OK)) {
                            return response.bodyToMono(Object[].class);
                        } else {
                            return response.createException()
                                    .flatMap(Mono::error);
                        }
                    });
            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<ResponseEntity<?>> consultarUsuarioResetPassword(CredencialDto credenciales, String username) {

        try {

            Object[] objects = consultarUsuarioPorUserName(username).block();

            if (objects.length > 0) {
                // Map<String, String> map = (Map<String, String>) objects[0];
                Map<String, String> map = new HashMap<String, String>();
                map = (Map<String, String>) objects[0];

                String id = map.get("id");
                System.out.println(id);

                Mono<ResponseEntity<?>> mono = resetPassword(credenciales, id);
                return mono;
            } else {
                return Mono.empty();
            }
        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<ResponseEntity<?>> resetPassword(CredencialDto credenciales, String idUsuario) {
        try {
            String url = prop.getResourceServerURLUsers() + "/users/" + idUsuario + "/reset-password";

            Mono<ResponseEntity<?>> retrievedResource = webClient.put()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("ciudadanosRealm"))
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(credenciales)
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.NO_CONTENT)) {
                            return Mono.just(new ResponseEntity<Mono<?>>(HttpStatus.OK));
                        } else {
                            return Mono.just(new ResponseEntity<Mono<?>>(response.statusCode()));
                        }
                    });

            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<ResponseEntity<?>> habilitarDeshabilitarUsuario(String user_id, boolean enabled) {
        try {
            String url = prop.getResourceServerURLUsers() + "/users/" + user_id;

            var body = "{" + '"' + "enabled" + '"' + ": " + enabled + "}";

            Mono<ResponseEntity<?>> retrievedResource = webClient.put()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("ciudadanosRealm"))
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(body)
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.NO_CONTENT)) {
                            return Mono.just(new ResponseEntity<Mono<?>>(HttpStatus.OK));
                        } else {
                            return Mono.just(new ResponseEntity<Mono<?>>(response.statusCode()));
                        }
                    });

            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<Object[]> consultarCliente(String client_id) {
        try {
            String url = prop.getResourceServerURLUsers() + "/clients?clientId=" + client_id;

            Mono<Object[]> retrievedResource = webClient.get()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("ciudadanosRealm"))
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.OK)) {
                            return response.bodyToMono(Object[].class);
                        } else {
                            return response.createException()
                                    .flatMap(Mono::error);
                        }
                    }).cast(Object[].class);

            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    // Se consulta el Id del cliente del reino Municipales para luego consultar los
    // roles
    public Mono<Object[]> consultarRolesCliente(String client_id) {

        try {

            Object[] objects = consultarCliente(client_id).block();

            if (objects.length > 0) {
                // Map<String, String> map = (Map<String, String>) objects[0];
                Map<String, String> map = new HashMap<String, String>();
                map = (Map<String, String>) objects[0];

                String id = map.get("id");
                System.out.println(id);

                Mono<Object[]> mono = consultarRoles(id);
                return mono;
            } else {
                return Mono.empty();
            }
        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<Object[]> consultarRoles(String idCliente) {
        try {
            String url = prop.getResourceServerURLUsers() + "/clients/" + idCliente + "/roles";

            Mono<Object[]> retrievedResource = webClient.get()
                    .uri(url)
                    .attributes(
                            ServerOAuth2AuthorizedClientExchangeFilterFunction
                                    .clientRegistrationId("ciudadanosRealm"))
                    .exchangeToMono(response -> {
                        if (response.statusCode()
                                .equals(HttpStatus.OK)) {
                            return response.bodyToMono(Object[].class);
                        } else {
                            return response.createException()
                                    .flatMap(Mono::error);
                        }
                    }).cast(Object[].class);

            return retrievedResource;

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<ResponseEntity<?>> addRolClientUser(String user_id, String client_id, Role[] roles) {
        try {

            // Se consulta el id del cliente
            Object[] objects = consultarCliente(client_id).block();

            if (objects.length > 0) {
                Map<String, String> map = new HashMap<String, String>();
                map = (Map<String, String>) objects[0];

                String idCliente = map.get("id");
                System.out.println(idCliente);

                String url = prop.getResourceServerURLUsers() + "/users/" + user_id + "/role-mappings/clients/"
                        + idCliente;

                // Se realiza la asignación del rol
                Mono<ResponseEntity<?>> retrievedResource = webClient.post()
                        .uri(url)
                        .attributes(
                                ServerOAuth2AuthorizedClientExchangeFilterFunction
                                        .clientRegistrationId("ciudadanosRealm"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(roles)
                        .exchangeToMono(response -> {
                            if (response.statusCode()
                                    .equals(HttpStatus.NO_CONTENT)) {
                                return Mono.just(new ResponseEntity<Mono<?>>(HttpStatus.CREATED));
                            } else {
                                return Mono.just(new ResponseEntity<Mono<?>>(response.statusCode()));
                            }
                        });

                return retrievedResource;
            } else {
                return Mono.empty();
            }

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }

    public Mono<ResponseEntity<?>> delRolClientUser(String user_id, String client_id, Role[] roles) {
        try {

            // Se consulta el id del cliente
            Object[] objects = consultarCliente(client_id).block();

            if (objects.length > 0) {
                Map<String, String> map = new HashMap<String, String>();
                map = (Map<String, String>) objects[0];

                String idCliente = map.get("id");
                System.out.println(idCliente);

                String url = prop.getResourceServerURLUsers() + "/users/" + user_id + "/role-mappings/clients/"
                        + idCliente;

                // Se realiza la asignación del rol
                Mono<ResponseEntity<?>> retrievedResource = ((RequestBodySpec) webClient.delete()
                        .uri(url)
                        .attributes(
                                ServerOAuth2AuthorizedClientExchangeFilterFunction
                                        .clientRegistrationId("ciudadanosRealm")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(roles)
                        .exchangeToMono(response -> {
                            if (response.statusCode()
                                    .equals(HttpStatus.NO_CONTENT)) {
                                return Mono.just(new ResponseEntity<Mono<?>>(HttpStatus.OK));
                            } else {
                                return Mono.just(new ResponseEntity<Mono<?>>(response.statusCode()));
                            }
                        });

                return retrievedResource;
            } else {
                return Mono.empty();
            }

        } catch (Throwable e) {
            return Mono.error(e);
        }
    }
}
