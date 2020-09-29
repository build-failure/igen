package com.buildfailure.yaig.entities;

import java.util.*;

public class InvoiceContext {

    private String id;

    private Locale locale;

    private Double vat;

    private String template;

    private Map<String, String> issuer = new HashMap<>();

    private Map<String, String> receiver = new HashMap<>();

    private List<Item> items = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<String, String> getIssuer() {
        return issuer;
    }

    public void setIssuer(Map<String, String> issuer) {
        this.issuer = issuer;
    }

    public Map<String, String> getReceiver() {
        return receiver;
    }

    public void setReceiver(Map<String, String> receiver) {
        this.receiver = receiver;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Double getTotalNet(){
        return getItems()
                .stream()
                .map(Item::getTotal)
                .reduce(.0, Double::sum);
    }

    public Double getTotalGross(){
        return getTotalNet() * (1 + getVat());
    }

    public Double getTotalVat(){
        return getTotalNet() * getVat();
    }
}
