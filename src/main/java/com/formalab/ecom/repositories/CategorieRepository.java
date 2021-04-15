package com.formalab.ecom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formalab.ecom.entities.Categorie;



@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
