package com.buildfailure.yaig.services;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

import static java.text.MessageFormat.format;

@Service
public class FileLoader {

    private final ResourceLoader resourceLoader;

    public FileLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public File getFile(String location){
        try {
            return resourceLoader.getResource(location).getFile();
        } catch (IOException e){
            throw new RuntimeException(format("Can not resolve location {0} to file.", location), e);
        }
    }
}
