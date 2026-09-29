package com.sougata.ecommerce.project.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        SecurityScheme bearerScheme = new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT").description("JWT Bearer Token");

        SecurityRequirement bearerRequirement = new SecurityRequirement().addList("Bearer Authentication");

        return new OpenAPI()
                .info(new Info()
                        .title("Ecommerce Website APIs ")
                        .version("1.0")
                        .description("This is a Spring Boot project for Ecommerce")
                        .license(new License().name("MIT License").url("https://opensource.org/license/mit"))
                        .contact(new Contact()
                                .name("Sougata Paul")
                                .email("work.sougatapaul@gmail.com")
                                .url("https://github.com/Sougata2006")
                        )
                )
                .components(new Components()
                .addSecuritySchemes("Bearer Authentication", bearerScheme)).addSecurityItem(bearerRequirement);
    }
}
