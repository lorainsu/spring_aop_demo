package com.lorain.aopdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DateConfig {

    @Bean
    public Date mookDate(){
        return new Date(1L);
    }
}

