package com.buildfailure.yaig.services;

import com.buildfailure.yaig.props.ApplicationProps;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import static java.text.MessageFormat.format;

@Service
public class ConfigReader {

    private final ObjectMapper objectMapper;

    private final ApplicationProps props;

    private final ResourceLoader resourceLoader;

    public ConfigReader(
            ObjectMapper objectMapper,
            ApplicationProps props,
            ResourceLoader resourceLoader
    ){
        this.objectMapper = objectMapper;
        this.props = props;
        this.resourceLoader = resourceLoader;
    }

    public <T> T read(String filePath, Class<T> type){
        Resource resource = resourceLoader.getResource(props.getSourceDir() + "/" + filePath);
        try {
            return objectMapper.readValue(resource.getInputStream(), type);
        } catch (Exception e){
            throw new RuntimeException(format("Can not parse {0} to {1}.", filePath, type), e);
        }
    }
}
