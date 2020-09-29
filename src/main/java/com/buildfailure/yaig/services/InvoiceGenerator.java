package com.buildfailure.yaig.services;

import com.buildfailure.yaig.entities.InvoiceContext;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import java.nio.file.Path;
import java.util.List;

@Service
public class InvoiceGenerator {

    private final TemplateEngine templateEngine;

    private final ConfigReader configReader;

    private final InvoicePathProvider invoicePathProvider;

    private final InvoiceWriter invoiceWriter;

    private final ContextMerger contextMerger;

    private final ContextMapper contextMapper;

    public InvoiceGenerator(
            TemplateEngine templateEngine,
            ConfigReader configReader,
            InvoicePathProvider invoicePathProvider,
            InvoiceWriter invoiceWriter,
            ContextMerger contextMerger,
            ContextMapper contextMapper
    ){
        this.templateEngine = templateEngine;
        this.configReader = configReader;
        this.invoicePathProvider = invoicePathProvider;
        this.invoiceWriter = invoiceWriter;
        this.contextMerger = contextMerger;
        this.contextMapper = contextMapper;
    }

    public void generate(){
        InvoiceContext baseInvoiceContext = configReader.read("main.yml", InvoiceContext.class);
        List<Path> invoicePaths = invoicePathProvider.get();

        for(Path invoicePath : invoicePaths){
            String fileName = invoicePath.getFileName().toString();
            InvoiceContext individualInvoiceContext = configReader.read("invoices/" + fileName, InvoiceContext.class);
            InvoiceContext invoiceContext = contextMerger.merge(baseInvoiceContext, individualInvoiceContext);

            String content = templateEngine.process(invoiceContext.getTemplate(), contextMapper.map(invoiceContext));

            invoiceWriter.write(invoiceContext.getId(), content);
        }
    }
}
