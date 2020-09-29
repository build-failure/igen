package com.buildfailure.yaig.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceGeneratorTest {

    @Autowired
    private InvoiceGenerator invoiceGenerator;

    @Test
    public void shouldGenerate(){
        invoiceGenerator.generate();
    }
}
