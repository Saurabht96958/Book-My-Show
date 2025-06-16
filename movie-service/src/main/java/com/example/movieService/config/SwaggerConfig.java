package com.example.movieService.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    //customize metadata like title, version, and description
    @Bean
    public OpenAPI movieServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Movie Service API")
                        .version("1.0")
                        .description("Microservice for managing movies in BookMyShow POC"));
    }

}
