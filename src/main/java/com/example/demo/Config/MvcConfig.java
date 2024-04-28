package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/control_panel").setViewName("control_panel");
        registry.addViewController("/public").setViewName("index");
        registry.addViewController("/public/index").setViewName("index");
        registry.addViewController("/public/about_us").setViewName("about_us");
        registry.addViewController("/public/gratitude").setViewName("gratitude");
        registry.addViewController("/public/more_information").setViewName("more_information");
    }

}
