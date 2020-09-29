package com.buildfailure.yaig.services;

import com.buildfailure.yaig.props.ApplicationProps;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;

import static java.text.MessageFormat.format;

@Service
public class InvoiceWriter {

    private final ApplicationProps props;

    private final FileLoader fileLoader;

    public InvoiceWriter(
        ApplicationProps props,
        FileLoader fileLoader
    ){
        this.props = props;
        this.fileLoader = fileLoader;
    }

    public void write(String fileName, String content){
        File file = new File(fileLoader.getFile(props.getBuildDir()), fileName + ".html");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (Exception e){
            throw new RuntimeException(format("Can not write to file {0}.", file.getAbsolutePath()), e);
        }
    }
}
