package com.formalab.ecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formalab.ecom.entities.Commande;
import com.formalab.ecom.exceptions.NotFoundException;
import com.formalab.ecom.services.CommandeService;

@RestController
@RequestMapping("commande")
public class CommandeController {

	@Autowired
	CommandeService commandeService;

	@PostMapping(path = "")
	public Commande saveCommande(@RequestBody Commande commande) {
		return commandeService.save(commande);
	}

	@GetMapping(path = "")
	public List<Commande> findAllCommande() {
		return commandeService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Commande findCommandeById(@PathVariable long id) {

		if (commandeService.findById(id).isPresent() == false) {
			throw new NotFoundException("Entity with id = " + id + "NOT FOUND");

		}

		return commandeService.findById(id).get();
	}

	@PutMapping(path = "")
	public Commande editCommande(@RequestBody Commande commande) {
		return commandeService.save(commande);
	}

	@DeleteMapping("")
	public void deleteCommande(@RequestBody Commande commande) {
		commandeService.delete(commande);

	}

	@DeleteMapping("/{id}")
	public void deleteCommandeById(@PathVariable Long id) {
		commandeService.deleteById(id);
	}

	@PostMapping(path = "produit/{idproduit}/utilisateur/{idUtilisateur}")
	public void saveCommandeProduit(@PathVariable Long idUtilisateur, @PathVariable Long idproduit,
			@RequestBody Commande commande) {

		commandeService.saveCommandeProduit(idproduit, idUtilisateur, commande);

	}

	@PostMapping(path = "/produit/utilisateur/{idUtilisateur}")
	public void saveCommandeProduitsAll(@PathVariable Long idUtilisateur, @RequestParam Long[] idp,
			@RequestBody Commande commande) {
		commandeService.saveCommandeProduitsAll(idUtilisateur, idp, commande);

	}
}
