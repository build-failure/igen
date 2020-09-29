package com.buildfailure.yaig.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.thymeleaf.templatemode.TemplateMode;

@Component
@ConfigurationProperties(prefix = "yaig")
public class ApplicationProps {

    private String baseDir = "./files";

    private String templateSuffix = ".html";

    private String sourceDir = getBaseDir() + "/src";

    private String invoiceDir = getSourceDir() + "/invoices";

    private String buildDir = getBaseDir() + "/dist";

    private String templatePath = getSourceDir() + "/templates/";

    private TemplateMode templateMode = TemplateMode.HTML;

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getTemplateSuffix() {
        return templateSuffix;
    }

    public void setTemplateSuffix(String templateSuffix) {
        this.templateSuffix = templateSuffix;
    }

    public String getInvoiceDir() {
        return invoiceDir;
    }

    public void setInvoiceDir(String invoiceDir) {
        this.invoiceDir = invoiceDir;
    }

    public TemplateMode getTemplateMode() {
        return templateMode;
    }

    public void setTemplateMode(TemplateMode templateMode) {
        this.templateMode = templateMode;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    public String getBuildDir() {
        return buildDir;
    }

    public void setBuildDir(String buildDir) {
        this.buildDir = buildDir;
    }

    public String getSourceDir() {
        return sourceDir;
    }

    public void setSourceDir(String sourceDir) {
        this.sourceDir = sourceDir;
    }
}
