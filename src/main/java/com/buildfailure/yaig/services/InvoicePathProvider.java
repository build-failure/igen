package com.buildfailure.yaig.services;

import com.buildfailure.yaig.props.ApplicationProps;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;

@Service
public class InvoicePathProvider {

    private final ApplicationProps props;

    private final FileLoader fileLoader;

    public InvoicePathProvider(
        ApplicationProps props,
        FileLoader fileLoader
    ){
        this.props = props;
        this.fileLoader = fileLoader;
    }

    public List<Path> get(){
        try {
            return Files.list(fileLoader.getFile(props.getInvoiceDir()).toPath())
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (Exception e){
            throw new RuntimeException(format("Can not read {0}.", props.getInvoiceDir()), e);
        }
    }
}
