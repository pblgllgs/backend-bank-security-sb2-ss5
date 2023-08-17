package com.pblgllgs.backendbanksecuritysb2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
public class SecurityFilterChainConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf().ignoringAntMatchers("/api/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/api/myAccount").hasRole("USER")
                        .antMatchers("/api/myBalance").hasAnyRole("USER", "ADMIN")
                        .antMatchers("/api/myLoans").hasRole("ROOT")
                        .antMatchers("/api/myCards").authenticated()
                        .antMatchers("/api/user").authenticated()
                        .antMatchers("/api/notices", "/api/contact").permitAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
