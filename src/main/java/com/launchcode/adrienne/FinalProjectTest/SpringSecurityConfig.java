package com.launchcode.adrienne.FinalProjectTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class SpringSecurityConfig implements WebMvcConfigurer {
    @Bean
    public Authentication authentication() {
        return new Authentication();
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        System.out.println("WebMvcConfigurer - addResourceHandlers() function get loaded...");
//        registry.addResourceHandler("/resources/static/**")
//                .addResourceLocations("/resources/");
////                .addResolver(new PathResourceResolver());
//
//        registry.addResourceHandler("/resources/templates/**")
//                .addResourceLocations("/resources/");
//        registry
//                .addResourceHandler("/js/**")
//                .addResourceLocations("/js/")
//                .setCachePeriod(3600)
//                .resourceChain(true)
//                .addResolver(new GzipResourceResolver())
//                .addResolver(new PathResourceResolver());
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor( authentication() ).addPathPatterns("/*");
    }

}


