package com.pblgllgs.backendbanksecuritysb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@EnableWebSecurity(debug = true)
public class BackendBankSecuritySb2Application {

	public static void main(String[] args) {
		SpringApplication.run(BackendBankSecuritySb2Application.class, args);
	}

}
