// package mdmq.gob.ec.loginkeycloak.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
// import org.springframework.hateoas.client.LinkDiscoverer;
// import org.springframework.hateoas.client.LinkDiscoverers;
// import
// org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
// import org.springframework.plugin.core.SimplePluginRegistry;

// import springfox.documentation.builders.PathSelectors;
// import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.spi.DocumentationType;
// import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
// import springfox.documentation.swagger.web.SwaggerResource;
// import springfox.documentation.swagger.web.SwaggerResourcesProvider;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;

// import java.util.ArrayList;
// import java.util.List;

// @Configuration
// @EnableSwagger2
// public class SwaggerConfig {
// @Bean
// public LinkDiscoverers discoverers() {
// List<LinkDiscoverer> plugins = new ArrayList<>();
// plugins.add(new CollectionJsonLinkDiscoverer());
// return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

// }

// // @Bean
// // public Docket api() {
// // return new Docket(DocumentationType.SWAGGER_2)
// // .select()
// // .apis(RequestHandlerSelectors.any())
// // .paths(PathSelectors.any())
// // .build();
// // }

// // @Primary
// // @Bean
// // public SwaggerResourcesProvider swaggerResourcesProvider(
// // InMemorySwaggerResourcesProvider defaultResourcesProvider) {
// // return () -> {
// // SwaggerResource wsResource = new SwaggerResource();
// // wsResource.setName("Documentation");
// // wsResource.setSwaggerVersion("3.0");
// // wsResource.setLocation("/swagger.yaml");

// // List<SwaggerResource> resources = new
// // ArrayList<>(defaultResourcesProvider.get());
// // resources.add(wsResource);
// // return resources;
// // };
// // }

// }
