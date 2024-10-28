package com.example.usercreator.infra.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI customOpenAPI() {
        Contact contact = new Contact();
        contact.setName("Saul Castro");
        contact.setName("Lsaulcastro@gmail.com");

        return new OpenAPI()
                .info(new Info()
                        .title("User Creator API")
                        .version("1.0")
                        .contact(contact)
                        .description("Description of creator users API"));
    }


}
