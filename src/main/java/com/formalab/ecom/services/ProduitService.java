package com.formalab.ecom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.formalab.ecom.entities.Categorie;
import com.formalab.ecom.entities.Produit;
import com.formalab.ecom.repositories.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	ProduitRepository produitRepository ;
	@Autowired
	CategorieService categorieService;
	
	public void saveProduitCategorie (Long idCategorie , Produit produit) {
		 Categorie categorie = categorieService.findById(idCategorie).get();
		 produit.setCategorie(categorie);
		 produitRepository.save(produit) ; 	
		 categorie.getProduits().add(produit);
		 categorieService.save(categorie);
	}
	
	public <S extends Produit> S save(S entity) {
		return produitRepository.save(entity);
	}

	public <S extends Produit> Optional<S> findOne(Example<S> example) {
		return produitRepository.findOne(example);
	}

	public Page<Produit> findAll(Pageable pageable) {
		return produitRepository.findAll(pageable);
	}

	public List<Produit> findAll() {
		return produitRepository.findAll();
	}

	public List<Produit> findAll(Sort sort) {
		return produitRepository.findAll(sort);
	}

	public List<Produit> findAllById(Iterable<Long> ids) {
		return produitRepository.findAllById(ids);
	}

	public <S extends Produit> List<S> saveAll(Iterable<S> entities) {
		return produitRepository.saveAll(entities);
	}

	public Optional<Produit> findById(Long id) {
	
			
		
		return produitRepository.findById(id);
	}

	public void flush() {
		produitRepository.flush();
	}

	public <S extends Produit> S saveAndFlush(S entity) {
		return produitRepository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return produitRepository.existsById(id);
	}

	public void deleteInBatch(Iterable<Produit> entities) {
		produitRepository.deleteInBatch(entities);
	}

	public <S extends Produit> Page<S> findAll(Example<S> example, Pageable pageable) {
		return produitRepository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		produitRepository.deleteAllInBatch();
	}

	public Produit getOne(Long id) {
		return produitRepository.getOne(id);
	}

	public <S extends Produit> long count(Example<S> example) {
		return produitRepository.count(example);
	}

	public <S extends Produit> boolean exists(Example<S> example) {
		return produitRepository.exists(example);
	}

	public <S extends Produit> List<S> findAll(Example<S> example) {
		return produitRepository.findAll(example);
	}

	public long count() {
		return produitRepository.count();
	}

	public void deleteById(Long id) {
		produitRepository.deleteById(id);
	}

	public <S extends Produit> List<S> findAll(Example<S> example, Sort sort) {
		return produitRepository.findAll(example, sort);
	}

	public void delete(Produit entity) {
		produitRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Produit> entities) {
		produitRepository.deleteAll(entities);
	}

	public void deleteAll() {
		produitRepository.deleteAll();
	}

	
	
}
