package com.fabrica.CheckIn.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/graphql").authenticated() // Protege el endpoint GraphQL
                        .anyRequest().permitAll() // Permite el acceso a otras rutas
                )
                .httpBasic(httpBasic -> {}); // Configura httpBasic correctamente con una lambda vacía

        return http.build();
    }
}