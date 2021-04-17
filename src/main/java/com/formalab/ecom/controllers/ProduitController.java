package com.formalab.ecom.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formalab.ecom.entities.Produit;

import com.formalab.ecom.exceptions.NotFoundException;
import com.formalab.ecom.repositories.CategorieRepository;
import com.formalab.ecom.services.ProduitService;

@RestController
@RequestMapping("produit")
public class ProduitController {

	@Autowired
	ProduitService produitService;
	@Autowired
	CategorieRepository categorieRepository;

	@PostMapping(path = "")
	public Produit saveProduit(@RequestBody Produit produit) {
		return produitService.save(produit);
	}

	@GetMapping(path = "")
	public List<Produit> findAllProduit() {
		return produitService.findAll();
	}

	@ExceptionHandler(Exception.class)
	@GetMapping(path = "/{id}")
	public Optional<Produit> findProduitById(@PathVariable long id) throws NotFoundException {
		Optional<Produit> produit = produitService.findById(id);

		if (produit.isPresent() == false) {
			throw new NotFoundException("Entity with id = " + id + "NOT FOUND");
		}

		return produitService.findById(id);
	}

	@PutMapping(path = "")
	public Produit editProduit(@RequestBody Produit produit) {
		return produitService.save(produit);
	}

	@DeleteMapping("")
	public void deleteProduit(@RequestBody Produit produit) {
		produitService.delete(produit);
	}

	@DeleteMapping("/{id}")
	public void deleteProduitById(@PathVariable Long id) {
		produitService.deleteById(id);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping(path = "categorie/{idCategorie}")
	public void saveProduitCategorie(@PathVariable long idCategorie, @RequestBody Produit produit) {
		produitService.saveProduitCategorie(idCategorie, produit);
	}

}
