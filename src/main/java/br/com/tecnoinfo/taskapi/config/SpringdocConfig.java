package br.com.tecnoinfo.taskapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
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
        return new OpenAPI()
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
