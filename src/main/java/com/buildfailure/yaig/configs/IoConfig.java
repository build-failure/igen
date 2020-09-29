package com.buildfailure.yaig.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IoConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper(new YAMLFactory());
    }
}
