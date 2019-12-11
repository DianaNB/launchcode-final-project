package com.launchcode.adrienne.FinalProjectTest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.MappedInterceptor;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class SpringSecurityConfig implements WebMvcConfigurer{
    @Bean
    public Authentication authentication() {
        return new Authentication();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new MappedInterceptor(new String[]{"/**"}, new String[]{"/images/**"}, authentication()) );
    }
    }


