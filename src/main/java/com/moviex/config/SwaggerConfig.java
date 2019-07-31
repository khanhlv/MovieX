package com.moviex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static Set<String> producesAndConsumes = new HashSet<>(Arrays.asList("application/json"));

    @Bean
    public Docket api() {
        List<SecurityScheme> schemeList = new ArrayList<>();
        schemeList.add(new ApiKey("X-TOKEN-AUTH", "test", "header"));
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(producesAndConsumes)
                .consumes(producesAndConsumes)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.moviex.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(schemeList)
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
