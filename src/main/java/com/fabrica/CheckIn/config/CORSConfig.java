package com.fabrica.CheckIn.config;

<<<<<<< HEAD
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
=======
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
>>>>>>> 93fd61142d16f81751e03dcd920d9c7f5625659f

@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
    }
}
