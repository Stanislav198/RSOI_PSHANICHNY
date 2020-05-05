package com.stas.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/accounts").setViewName("accounts");
        registry.addViewController("/").setViewName("accounts");
        registry.addViewController("/authorization").setViewName("authorization");
    }

}
