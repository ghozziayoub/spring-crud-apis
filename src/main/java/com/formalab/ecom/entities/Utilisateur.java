package com.formalab.ecom.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String nom ; 
	private String prenom ;
	private String pseudo ;
	private String adresse ; 
	
	private String email ; 
	private String password ;
	private String role;
	
	@JsonBackReference
	@OneToMany(mappedBy = "utilisateur")
	private List<Commande> commandes = new ArrayList<>() ;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	public Utilisateur(Long id, String nom, String prenom, String pseudo, String adresse, String email, String password,
			String role, List<Commande> commandes) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.adresse = adresse;
		this.email = email;
		this.password = password;
		this.role = role;
		this.commandes = commandes;
	}

	public Utilisateur() {
		super();
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", adresse="
				+ adresse + ", email=" + email + ", password=" + password + ", role=" + role + ", commandes="
				+ commandes + "]";
	}



	
	
	
	
	
}
