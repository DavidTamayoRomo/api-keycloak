package gob.mdmq.api.keycloak.consultarciu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.InMemoryReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.web.reactive.function.client.WebClient;

import gob.mdmq.api.keycloak.consultarciu.security.ProjectProperties;

@EnableWebSecurity
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
  ReactiveClientRegistrationRepository clientRegistrations(

  ) {
    ClientRegistration registration = ClientRegistration
        .withRegistrationId("appCiudadanos")
        .tokenUri(propiedades.getToken_uri())
        .clientId(propiedades.getClient_id())
        .clientSecret(propiedades.getClient_secret())
        .scope(propiedades.getScope())
        .authorizationGrantType(new AuthorizationGrantType(propiedades.getAuthorizationGrantType()))
        .build();
    return new InMemoryReactiveClientRegistrationRepository(registration);
  }

  @Bean
  WebClient webClient(ReactiveClientRegistrationRepository clientRegistrations) {
    InMemoryReactiveOAuth2AuthorizedClientService clientService = new InMemoryReactiveOAuth2AuthorizedClientService(
        clientRegistrations);
    AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager authorizedClientManager = new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(
        clientRegistrations, clientService);
    ServerOAuth2AuthorizedClientExchangeFilterFunction oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(
        authorizedClientManager);
    oauth.setDefaultClientRegistrationId("appCiudadanos");
    return WebClient.builder()
        .filter(oauth)
        .build();

  }

}
