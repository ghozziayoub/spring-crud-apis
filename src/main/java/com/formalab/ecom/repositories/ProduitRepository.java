package com.formalab.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formalab.ecom.entities.Produit;



@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	
	
	
	
}
