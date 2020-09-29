package com.buildfailure.yaig.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.thymeleaf.templatemode.TemplateMode;

@Component
@ConfigurationProperties(prefix = "yaig")
public class ApplicationProps {

    private String baseDir;

    private String templateSuffix = ".html";

    private TemplateMode templateMode = TemplateMode.HTML;

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    public String getTemplateSuffix() {
        return templateSuffix;
    }

    public void setTemplateSuffix(String templateSuffix) {
        this.templateSuffix = templateSuffix;
    }

    public TemplateMode getTemplateMode() {
        return templateMode;
    }

    public void setTemplateMode(TemplateMode templateMode) {
        this.templateMode = templateMode;
    }

    public String getTemplatePath() {
        return getSourceDir() + "/templates/";
    }
    public String getInvoiceDir() {
        return getSourceDir() + "/invoices";
    }

    public String getBuildDir() {
        return getBaseDir() + "/dist";
    }

    public String getSourceDir() {
        return getBaseDir() + "/src";
    }
}
