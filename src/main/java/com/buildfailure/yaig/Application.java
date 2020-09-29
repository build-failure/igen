package com.buildfailure.yaig;

import com.buildfailure.yaig.services.InvoiceGenerator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements ApplicationRunner {

    private final InvoiceGenerator invoiceGenerator;

    public Application(InvoiceGenerator invoiceGenerator){
        this.invoiceGenerator = invoiceGenerator;
    }

    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        invoiceGenerator.generate();
    }
}
