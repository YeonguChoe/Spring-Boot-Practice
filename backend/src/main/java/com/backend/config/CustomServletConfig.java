package com.backend.config;

import com.backend.controller.formatter.LocalDateFormatter;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//Configuration 파일이라고 명시적으로 말한다.
@Configuration
@Log4j2
public class CustomServletConfig implements WebMvcConfigurer {
    // formatter 를 사용한다고 설정한다.

    @Override
    public void addFormatters(FormatterRegistry registry) {

        log.info("add formatter가 실행된다");
        registry.addFormatter(new LocalDateFormatter());
    }

    // @Override
    // public void addCorsMappings(CorsRegistry registry) {
    //     registry.addMapping("/**")
    //             .maxAge(500)
    //             .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
    //             .allowedOrigins("*");
    // }
}
