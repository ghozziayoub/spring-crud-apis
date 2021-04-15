package com.formalab.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.formalab.ecom.security.JWTAuthentificationFilter;

@SpringBootApplication
public class FinalEcomProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalEcomProjectApplication.class, args);
	}
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder () {
		return new BCryptPasswordEncoder() ;
	} ;



	
	
	}
