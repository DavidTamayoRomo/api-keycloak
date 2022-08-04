package mdmq.gob.ec.loginkeycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//http://localhost:8084/swagger-ui/index.html

@CrossOrigin(origins = "*")
@EnableAutoConfiguration
@EnableConfigurationProperties
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Login Keycloak", version = "1.0", description = "Servicio web que permite obtener y validar token, además cerrar la ssión en el Servidor de Autenticación Keycloak."))
public class LoginKeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginKeycloakApplication.class, args);
	}

}
