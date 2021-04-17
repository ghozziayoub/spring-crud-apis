package com.formalab.ecom.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String nom ;
	
	private String description ;
	
	private float prix ;
	
	private String image ;
	
	@ManyToOne 
	private Categorie categorie ;
	
	@JsonBackReference

	@ManyToMany
    @JoinTable( name = "T_Produits_Commandes",
    joinColumns = @JoinColumn( name = "idProduit" ),
    inverseJoinColumns = @JoinColumn( name = "idCommande" ) )
	private List<Commande>  commandes = new ArrayList<>() ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Produit(Long id, String nom, String description, float prix, String image, Categorie categorie,
			List<Commande> commandes) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.categorie = categorie;
		this.commandes = commandes;
	}

	public Produit() {
		super();
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", image="
				+ image + ", categorie=" + categorie + ", commandes=" + commandes + "]";
	} 


	

	

	
	
	
	
}
