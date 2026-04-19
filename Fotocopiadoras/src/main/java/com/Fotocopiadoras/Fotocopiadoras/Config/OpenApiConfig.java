package com.Fotocopiadoras.Fotocopiadoras.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("unused")
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API Gestión de Fotocopiadoras")
                .version("1.0.0")
                .description("Sistema web completo para la gestión de equipos fotocopiadores")
                .contact(new Contact()
                    .name("Soporte")
                    .email("soporte@fotocopiadoras.com")
                )
            );
    }
}
