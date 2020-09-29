package com.buildfailure.yaig.services;

import com.buildfailure.yaig.entities.InvoiceContext;
import org.springframework.stereotype.Service;

@Service
public class ContextMerger {

    public InvoiceContext merge(InvoiceContext base, InvoiceContext individual){
        InvoiceContext invoiceContext = new InvoiceContext();
        if(individual.getId() != null){
            invoiceContext.setId(individual.getId());
        } else {
            invoiceContext.setId(base.getId());
        }
        if(individual.getVat() != null){
            invoiceContext.setVat(individual.getVat());
        } else {
            invoiceContext.setVat(base.getVat());
        }
        if(individual.getLocale() != null){
            invoiceContext.setLocale(individual.getLocale());
        } else {
            invoiceContext.setLocale(base.getLocale());
        }
        if(individual.getTemplate() != null){
            invoiceContext.setTemplate(individual.getTemplate());
        } else {
            invoiceContext.setTemplate(base.getTemplate());
        }

        invoiceContext.getIssuer().putAll(base.getIssuer());
        invoiceContext.getIssuer().putAll(individual.getIssuer());

        invoiceContext.getReceiver().putAll(base.getReceiver());
        invoiceContext.getReceiver().putAll(individual.getReceiver());

        invoiceContext.getItems().addAll(base.getItems());
        invoiceContext.getItems().addAll(individual.getItems());

        return invoiceContext;
    }
}
