package com.buildfailure.yaig.configs;

import com.buildfailure.yaig.props.ApplicationProps;
import com.buildfailure.yaig.services.FileLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class RenderingConfig {

    @Bean
    public FileTemplateResolver templateResolver(ApplicationProps props, FileLoader fileLoader){
        FileTemplateResolver templateResolver = new FileTemplateResolver();
        templateResolver.setPrefix(fileLoader.getFile(props.getTemplatePath()).getAbsolutePath() + "/");
        templateResolver.setSuffix("");
        templateResolver.setTemplateMode(props.getTemplateMode());
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setEnableSpringELCompiler(true);
        templateEngine.addDialect(new Java8TimeDialect());
        return templateEngine;
    }
}
