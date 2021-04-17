package com.formalab.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formalab.ecom.entities.Utilisateur;

 
 
@Repository
public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long>{

	
	
	Utilisateur findByEmail(String email);
	
	
	
	
}
