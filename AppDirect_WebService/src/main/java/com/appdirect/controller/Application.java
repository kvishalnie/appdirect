package com.appdirect.controller;


import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.appdirect.*")
public class Application {
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
     
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("appdirect-subscription")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/appDirect.*"))
                .build();
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Appdirect Subscription")
                .description("Appdirect Subscription")
                .contact("Vishal Khanapur")
                .build();
    }
}