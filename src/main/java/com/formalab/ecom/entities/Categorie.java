package com.formalab.ecom.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	
	private String libele ; 
	
	@JsonIgnoreProperties("categorie")
	@OneToMany(targetEntity = Produit.class , mappedBy = "categorie") 
	private List<Produit> produits = new ArrayList<>() ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Categorie(Long idCategorie, String libele, List<Produit> produits) {
		super();
		this.id = idCategorie;
		this.libele = libele;
		this.produits = produits;
	}

	public Categorie() {
		super();
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + id + ", libele=" + libele + ", produits=" + produits + "]";
	}
	
	
}


