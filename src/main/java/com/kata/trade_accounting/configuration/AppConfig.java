package com.kata.trade_accounting.configuration;


import org.springframework.context.annotation.Configuration;
@Configuration
@EnableSwagger2
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kata.trade_accounting.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
