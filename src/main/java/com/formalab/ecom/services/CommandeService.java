package com.formalab.ecom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.formalab.ecom.entities.Commande;
import com.formalab.ecom.entities.Produit;
import com.formalab.ecom.entities.Utilisateur;
import com.formalab.ecom.repositories.CommandeRepository;


@Service
public class CommandeService {

	@Autowired
	CommandeRepository commandeRepository ;
	@Autowired
	ProduitService produitService ; 
	@Autowired
	UtilisateurService utilisateurService ;
	
	public void saveCommandeProduit (Long idproduit , Long idUtilisateur , Commande commande ) {
		Produit produit = produitService.getOne(idproduit);
		Utilisateur utilisateur = utilisateurService.getOne(idUtilisateur);
		commande.setUtilisateur(utilisateur);
		commande.getListProduit().add(produit);
		commandeRepository.save(commande) ;
		produit.getCommandes().add(commande);
		produitService.save(produit);
		utilisateur.getCommandes().add(commande);
		utilisateurService.save(utilisateur);
	}
	
	public void saveCommandeProduitsAll (Long idUtilisateur ,
		Long [] idp, Commande commande) {
		Utilisateur utilisateur = utilisateurService.getOne(idUtilisateur);
		commande.setUtilisateur(utilisateur);
		
		for (int i = 0; i < idp.length; i++) {
			Produit produit = produitService.getOne(idp[i]);
			commande.getListProduit().add(produit);
			produit.getCommandes().add(commande);
			commandeRepository.save(commande) ;
			produitService.save(produit);
		}
		
		
		utilisateur.getCommandes().add(commande);
		utilisateurService.save(utilisateur);	
		
	}
	
	
	public <S extends Commande> S save(S entity) {
		return commandeRepository.save(entity);
	}

	public <S extends Commande> Optional<S> findOne(Example<S> example) {
		return commandeRepository.findOne(example);
	}

	public Page<Commande> findAll(Pageable pageable) {
		return commandeRepository.findAll(pageable);
	}

	public List<Commande> findAll() {
		return commandeRepository.findAll();
	}

	public List<Commande> findAll(Sort sort) {
		return commandeRepository.findAll(sort);
	}

	public List<Commande> findAllById(Iterable<Long> ids) {
		return commandeRepository.findAllById(ids);
	}

	public <S extends Commande> List<S> saveAll(Iterable<S> entities) {
		return commandeRepository.saveAll(entities);
	}

	public Optional<Commande> findById(Long id) {
		return commandeRepository.findById(id);
	}

	public void flush() {
		commandeRepository.flush();
	}

	public <S extends Commande> S saveAndFlush(S entity) {
		return commandeRepository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return commandeRepository.existsById(id);
	}

	public void deleteInBatch(Iterable<Commande> entities) {
		commandeRepository.deleteInBatch(entities);
	}

	public <S extends Commande> Page<S> findAll(Example<S> example, Pageable pageable) {
		return commandeRepository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		commandeRepository.deleteAllInBatch();
	}

	public Commande getOne(Long id) {
		return commandeRepository.getOne(id);
	}

	public <S extends Commande> long count(Example<S> example) {
		return commandeRepository.count(example);
	}

	public <S extends Commande> boolean exists(Example<S> example) {
		return commandeRepository.exists(example);
	}

	public <S extends Commande> List<S> findAll(Example<S> example) {
		return commandeRepository.findAll(example);
	}

	public long count() {
		return commandeRepository.count();
	}

	public void deleteById(Long id) {
		commandeRepository.deleteById(id);
	}

	public <S extends Commande> List<S> findAll(Example<S> example, Sort sort) {
		return commandeRepository.findAll(example, sort);
	}

	public void delete(Commande entity) {
		commandeRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Commande> entities) {
		commandeRepository.deleteAll(entities);
	}

	public void deleteAll() {
		commandeRepository.deleteAll();
	}
	
	
}
