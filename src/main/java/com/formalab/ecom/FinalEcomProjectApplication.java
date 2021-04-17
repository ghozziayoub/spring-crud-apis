package com.formalab.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
