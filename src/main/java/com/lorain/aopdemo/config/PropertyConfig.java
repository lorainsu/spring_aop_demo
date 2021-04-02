package com.lorain.aopdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:conf/secret.properties")
@Getter
@Setter
public class PropertyConfig {

    @Value("${root.ak}")
    private String ak;


}

