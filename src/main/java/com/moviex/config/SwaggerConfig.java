package com.moviex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static Set<String> producesAndConsumes = new HashSet<>(Arrays.asList("application/json"));

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("X-TOKEN-AUTH", authorizationScopes));
    }

    @Bean
    public Docket api() {

        SecurityContext securityContexts = SecurityContext.builder().securityReferences(defaultAuth()).build();

        return new Docket(DocumentationType.SWAGGER_2)
                .produces(producesAndConsumes)
                .consumes(producesAndConsumes)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.moviex.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(new ApiKey("X-TOKEN-AUTH", "X-TOKEN-AUTH", "header")))
                .securityContexts(Collections.singletonList(securityContexts))
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "MovieX REST API",
                "Some custom description of API.",
                "1.0",
                "Terms of service",
                new Contact("KhanhLV", "moviex.com", "khanhlv.group1@gmail.com"),
                "License of API", "moviex.com", Collections.emptyList());
    }
}
