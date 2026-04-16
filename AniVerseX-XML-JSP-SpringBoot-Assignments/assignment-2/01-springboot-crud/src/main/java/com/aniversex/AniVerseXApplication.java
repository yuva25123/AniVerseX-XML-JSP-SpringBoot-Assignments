package com.aniversex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AniVerseXApplication extends SpringBootServletInitializer {

    // Required when deploying this app as WAR to external Tomcat.
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AniVerseXApplication.class);
    }

    // Starting point of Spring Boot application.
    public static void main(String[] args) {
        SpringApplication.run(AniVerseXApplication.class, args);
    }
}
