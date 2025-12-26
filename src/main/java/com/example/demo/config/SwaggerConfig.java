package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        Server server = new Server();
        server.setUrl("https://9032.pro604cr.amypo.ai/");
        server.setDescription("Production Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Post Surgery Recovery Tracker API")
                        .version("1.0")
                        .description("API documentation for Post Surgery Recovery System"))
                .servers(List.of(server));
    }
}
