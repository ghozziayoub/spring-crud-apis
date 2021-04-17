package com.formalab.ecom.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	
	private String libele ; 
	private String description ;
	private float prix ;
	
	@JsonIgnoreProperties("password")
	@ManyToOne 
	private Utilisateur utilisateur ; 
	
	@ManyToMany (fetch = FetchType.EAGER)
    @JoinTable( name = "T_Produits_Commandes", 
                joinColumns = @JoinColumn( name = "idCommande" ),
                inverseJoinColumns = @JoinColumn( name = "idProduit" ) )
	private List<Produit> listProduit = new ArrayList<>() ;

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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	

	

	public List<Produit> getListProduit() {
		return listProduit;
	}

	public void setListProduit(List<Produit> listProduit) {
		this.listProduit = listProduit;
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

	

	
	

	public Commande(Long id, String libele, String description, float prix, Utilisateur utilisateur,
			List<Produit> listProduit) {
		super();
		this.id = id;
		this.libele = libele;
		this.description = description;
		this.prix = prix;
		this.utilisateur = utilisateur;
		this.listProduit = listProduit;
	}

	public Commande() {
		super();
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", libele=" + libele + ", description=" + description + ", prix=" + prix
				+ ", utilisateur=" + utilisateur + ", listProduit=" + listProduit + "]";
	}



	
	
	
	
	
}
