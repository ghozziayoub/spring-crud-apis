package com.formalab.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formalab.ecom.entities.Commande;



@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

	
}
