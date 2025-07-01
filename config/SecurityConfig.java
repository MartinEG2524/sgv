package com.garritas.sgv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // ← Permite todo
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(form -> form.disable()) // ← Desactiva login
            .logout(logout -> logout.disable()); // ← Desactiva logout

            System.out.println("SEGURIDAD DESHABILITADA");

        return http.build();
    }
}
