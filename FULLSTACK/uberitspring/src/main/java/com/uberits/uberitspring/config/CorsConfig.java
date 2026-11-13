package com.uberits.uberitspring.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
    @Value("${frontend.url}")
    private String frontendUrl;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();

        // Angular frontend
        config.setAllowedOrigins(
            List.of(frontendUrl)
        );

        // HTTP methods
        config.setAllowedMethods(
            List.of(
                "GET",
                "POST",
                "PUT",
                "PATCH",
                "DELETE",
                "OPTIONS"
            )
        );

        // HTTP headers
        config.setAllowedHeaders(
            List.of("*")
        );

        // Headers accessible from Angular
        config.setExposedHeaders(
            List.of("Authorization")
        );

        // Enable cookies / credentials
        config.setAllowCredentials(true);

        // Cache preflight response (1 hour)
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return source;
    }
}

