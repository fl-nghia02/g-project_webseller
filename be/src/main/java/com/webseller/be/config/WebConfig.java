package com.webseller.be.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Cho phép tất cả các endpoint
                .allowedOrigins("http://localhost:3000")  // Cho phép origin từ front-end
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Các phương thức HTTP cho phép
                .allowedHeaders("*")  // Cho phép tất cả các header
                .allowCredentials(true);  // Cho phép gửi thông tin xác thực
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
