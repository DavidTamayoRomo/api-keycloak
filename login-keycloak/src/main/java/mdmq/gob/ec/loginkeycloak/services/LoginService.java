package mdmq.gob.ec.loginkeycloak.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import mdmq.gob.ec.loginkeycloak.models.LoginJwtResponse;
import mdmq.gob.ec.loginkeycloak.security.Propiedades;

@Service
public class LoginService {

    @Autowired
    Propiedades propiedades;

    public Object getToken(String realm, MultiValueMap<String, String> paramsMap) {

        RestTemplate restTemplate = new RestTemplate();

        String urlString = propiedades.getBase_uri() + "/" + realm + "/protocol/openid-connect/token";

        Object response = restTemplate.postForObject(
                urlString, paramsMap,
                LoginJwtResponse.class);

        return response;
    }

    public Object validateToken(String realm, String token) {

        RestTemplate restTemplate = new RestTemplate();

        String urlString = propiedades.getBase_uri() + "/" + realm + "/protocol/openid-connect/userinfo";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", token);

        ResponseEntity<Object> response = restTemplate.exchange(
                urlString,
                HttpMethod.GET,
                new HttpEntity<>("parameters", headers),
                Object.class);

        return response.getBody();
    }

    public Object logout(String realm, MultiValueMap<String, String> paramsMap) {

        RestTemplate restTemplate = new RestTemplate();

        String urlString = propiedades.getBase_uri() + "/" + realm + "/protocol/openid-connect/logout";

        Object response = restTemplate.postForObject(
                urlString, paramsMap,
                Object.class);

        return response;
    }
}
