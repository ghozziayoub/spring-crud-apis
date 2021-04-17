package com.formalab.ecom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.formalab.ecom.services.UtilisateurService;




@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private UserDetailsService userDetailsService ;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder ;

	 @Autowired 
	 UtilisateurService us ;
	

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(bCryptPasswordEncoder);


	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.addFilterBefore(corsFilter(), SessionManagementFilter.class) ;
		http.csrf().disable();
		  http.authorizeRequests().antMatchers(HttpMethod.GET,"/produit/**").permitAll();
		  http.authorizeRequests().antMatchers(HttpMethod.GET,"/categorie/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/login/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/register").permitAll();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) ;

		http.authorizeRequests().anyRequest().authenticated() ;

		
		http.addFilter(new JWTAuthentificationFilter(authenticationManager(),us ));
		
		http.addFilterBefore(new JWTAuthorizationFilter(   ), UsernamePasswordAuthenticationFilter.class) ;

		
	
	}

	
	
}
