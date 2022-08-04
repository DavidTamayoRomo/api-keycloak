package gob.mdmq.api.keycloak.gestionarusuariosmunicipales.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.InMemoryReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.web.reactive.function.client.WebClient;

import gob.mdmq.api.keycloak.gestionarusuariosmunicipales.security.ProjectProperties;

@Configuration
public class ProjectConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.oauth2Client();
    http.authorizeRequests().anyRequest().permitAll();
  }

  @Autowired
  private ProjectProperties propiedades;

  @Bean
  ReactiveClientRegistrationRepository clientRegistrationsRegistro() {
    ClientRegistration registrationRegistro = ClientRegistration
        .withRegistrationId("municipalesRealm")
        .tokenUri(propiedades.getToken_uri_registro())
        .clientId(propiedades.getClient_id_registro())
        .clientSecret(propiedades.getClient_secret_registro())
        .authorizationGrantType(new AuthorizationGrantType(propiedades.getAuthorizationGrantType_registro()))
        .build();
    return new InMemoryReactiveClientRegistrationRepository(registrationRegistro);
  }

  @Bean
  WebClient webClientRegistro(ReactiveClientRegistrationRepository clientRegistrationsRegistro) {
    InMemoryReactiveOAuth2AuthorizedClientService clientService = new InMemoryReactiveOAuth2AuthorizedClientService(
        clientRegistrationsRegistro);
    AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager authorizedClientManager = new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(
        clientRegistrationsRegistro, clientService);
    ServerOAuth2AuthorizedClientExchangeFilterFunction oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(
        authorizedClientManager);
    oauth.setDefaultClientRegistrationId("municipalesRealm");
    return WebClient.builder()
        .filter(oauth)
        .build();
  }
}
