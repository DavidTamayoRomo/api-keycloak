package mdmq.gob.ec.loginkeycloak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mdmq.gob.ec.loginkeycloak.services.LoginService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    LoginService service;

    @PostMapping(path = "/oauth/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getToken(@RequestParam String realm,
            @RequestBody MultiValueMap<String, String> paramsMap) {
        return ResponseEntity.ok(service.getToken(realm, paramsMap));
    }

    // @PostMapping(path = "/oauth/validate/token", produces =
    // MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Object> validateToken(@RequestParam String realm,
    // @RequestHeader("Authorization") String token) {
    // return ResponseEntity.ok(service.validateToken(realm, token));
    // }

    @PostMapping(path = "/user/logout", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> logout(@RequestParam String realm,
            @RequestBody MultiValueMap<String, String> paramsMap) {
        return ResponseEntity.ok(service.logout(realm, paramsMap));
    }
}