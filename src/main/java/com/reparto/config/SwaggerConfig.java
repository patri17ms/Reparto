package com.reparto.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Retrieves a configuration Bean for Swagger documentation.
     * 
     * @return The {@link Docket} for Swagger documentation
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.reparto.rest")).paths(PathSelectors.any())
                .build().apiInfo(getApiInfo());
    }

    /**
     * Retrieves the API information.
     * 
     * @return The {@link ApiInfo} API information
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("Reparto Rest").description("Reparto de pedidos.")
                .version("1.0").build();
    }
}
