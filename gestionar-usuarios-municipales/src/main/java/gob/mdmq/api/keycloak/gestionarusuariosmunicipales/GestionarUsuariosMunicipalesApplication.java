package gob.mdmq.api.keycloak.gestionarusuariosmunicipales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

//http://localhost:8085/swagger-ui/index.html
//http://localhost:8085/swagger-ui/v3/api-docs.yaml

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Gestionar Usuarios Municipales", version = "1.0", description = "Servicio web que permite listar usuarios federados del Ldap, roles por cliente y asignar roles a un usuario"))
public class GestionarUsuariosMunicipalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionarUsuariosMunicipalesApplication.class, args);
	}

}
