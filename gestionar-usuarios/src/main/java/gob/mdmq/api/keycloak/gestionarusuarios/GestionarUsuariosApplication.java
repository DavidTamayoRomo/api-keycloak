package gob.mdmq.api.keycloak.gestionarusuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//http://localhost:8082/swagger-ui/index.html
//http://localhost:8082/swagger-ui/v3/api-docs.yaml//

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Gestionar Usuarios", version = "1.0", description = "Servicio web que permite registrar usuarios en el reino Ciudadanos del keycloak, cambiar password y habilitar o deshabilitar usuarios"))
public class GestionarUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionarUsuariosApplication.class, args);
	}

}
