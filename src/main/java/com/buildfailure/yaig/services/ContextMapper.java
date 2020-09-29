package com.buildfailure.yaig.services;

import com.buildfailure.yaig.entities.InvoiceContext;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.time.LocalDate;

@Service
public class ContextMapper {

    public Context map(InvoiceContext invoiceContext){
        Context context = new Context();
        context.setLocale(invoiceContext.getLocale());
        context.setVariable("id", invoiceContext.getId());
        context.setVariable("vat", invoiceContext.getVat());
        context.setVariable("issuer", invoiceContext.getIssuer());
        context.setVariable("receiver", invoiceContext.getReceiver());
        context.setVariable("items", invoiceContext.getItems());
        context.setVariable("now", LocalDate.now());
        context.setVariable("total_net", invoiceContext.getTotalNet());
        context.setVariable("total_gross", invoiceContext.getTotalGross());
        context.setVariable("total_vat", invoiceContext.getTotalVat());
        return context;
    }
}
