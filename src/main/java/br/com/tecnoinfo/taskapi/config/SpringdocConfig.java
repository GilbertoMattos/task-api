package br.com.tecnoinfo.taskapi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringdocConfig implements WebMvcConfigurer {

    @Value("${swagger.versao}")
    private String versao;

    @Value("${swagger.titulo}")
    private String titulo;

    @Value("${swagger.descricao}")
    private String descricao;

    @Bean
    public GroupedOpenApi todos() {
        return GroupedOpenApi
                .builder()
                .group("Todos")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI openApi() {
        var securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                                .description("Insira aqui seu Token de autenticação")
                        )
                )
                .info(new Info()
                        .title(titulo)
                        .description(descricao)
                        .version(versao)
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://springdoc.org")
                        ));
    }
}
