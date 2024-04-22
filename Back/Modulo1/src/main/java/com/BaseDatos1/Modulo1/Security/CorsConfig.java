package com.BaseDatos1.Modulo1.Security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Utilizar allowedOriginPatterns en lugar de allowedOrigins
        config.setAllowedOriginPatterns(List.of("*"));

        // Permitir todos los métodos (GET, POST, PUT, DELETE, etc.)
        config.addAllowedMethod("*");

        // Permitir todos los encabezados
        config.addAllowedHeader("*");

        // Permitir credenciales
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
