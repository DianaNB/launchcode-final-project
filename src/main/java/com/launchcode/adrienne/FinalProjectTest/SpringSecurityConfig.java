package com.launchcode.adrienne.FinalProjectTest;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


public class SpringSecurityConfig extends WebMvcConfigurerAdapter {
    @Bean
    public Authentication authentication() {
        return new Authentication();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( authentication() );
    }

}


