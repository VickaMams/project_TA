package com.kata.trade_accounting.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperUtil {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}