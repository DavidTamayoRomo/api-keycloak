package gob.mdmq.api.keycloak.consultarciu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//http://localhost:8081/swagger-ui/index.html

@EnableConfigurationProperties
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Consultar Ciudadanos", version = "1.0", description = "Servicio Web que permite consultar y sincronizar ciudadanos con la Dinardap"))
public class ConsultarCiuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultarCiuApplication.class, args);
	}

}
