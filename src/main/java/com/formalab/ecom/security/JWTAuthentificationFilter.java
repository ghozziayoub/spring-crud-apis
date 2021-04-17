package com.formalab.ecom.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication ;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formalab.ecom.entities.Utilisateur;
import com.formalab.ecom.services.UtilisateurService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {



	
	private AuthenticationManager authenticationManager ;
	private UtilisateurService us;
	
	public JWTAuthentificationFilter(AuthenticationManager authenticationManager , UtilisateurService us) {
	super();
	this.us=us ;
	this.authenticationManager = authenticationManager;
	}


	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
	Utilisateur utilisateur = null ;


	try {
	/*recuperation du json envoyer par l'utilisateur pour s'authentifier 
	 et le stocker ou caster dans un objet Utilisateur */
	utilisateur = new ObjectMapper().readValue(request.getInputStream(),Utilisateur.class ) ;

	} catch (Exception e) {
	throw new RuntimeException(e) ;
	}

	return authenticationManager.authenticate(
	new UsernamePasswordAuthenticationToken(utilisateur.getEmail(), utilisateur.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
	Authentication authResult) throws IOException, ServletException {

	    User springuser = (User) authResult.getPrincipal();
	    System.out.println(springuser.getUsername());
	 
	    Utilisateur user = us.findByEmail(springuser.getUsername());
	    
	    
	        String jwt = Jwts.builder().setSubject(springuser.getUsername())
	                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
	                .signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
	                .claim("roles", user.getRole()).claim("User_Id", user.getId()) 
	                .compact();
	        System.out.println(jwt);
	        System.out.println(springuser.getAuthorities().toString());
	        response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + jwt  );

	}

}
