package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin/control_panel").setViewName("control_panel");
        registry.addViewController("/public").setViewName("index");
        registry.addViewController("/public/index").setViewName("index");
        registry.addViewController("/public/about_us").setViewName("about_us");
        registry.addViewController("/public/gratitude").setViewName("gratitude");
        registry.addViewController("/public/more_information").setViewName("more_information");
    }

}
