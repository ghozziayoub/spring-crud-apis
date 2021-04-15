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
import com.formalab.ecom.repositories.CategorieRepository;

@Service
public class CategorieService {
	@Autowired
	CategorieRepository categorieRepository ;

	public <S extends Categorie> S save(S entity) {
		return categorieRepository.save(entity);
	}

	public <S extends Categorie> Optional<S> findOne(Example<S> example) {
		return categorieRepository.findOne(example);
	}

	public Page<Categorie> findAll(Pageable pageable) {
		return categorieRepository.findAll(pageable);
	}

	public List<Categorie> findAll() {
		return categorieRepository.findAll();
	}

	public List<Categorie> findAll(Sort sort) {
		return categorieRepository.findAll(sort);
	}

	public List<Categorie> findAllById(Iterable<Long> ids) {
		return categorieRepository.findAllById(ids);
	}

	public <S extends Categorie> List<S> saveAll(Iterable<S> entities) {
		return categorieRepository.saveAll(entities);
	}

	public Optional<Categorie> findById(Long id) {
		return categorieRepository.findById(id);
	}

	public void flush() {
		categorieRepository.flush();
	}

	public <S extends Categorie> S saveAndFlush(S entity) {
		return categorieRepository.saveAndFlush(entity);
	}

	public boolean existsById(Long id) {
		return categorieRepository.existsById(id);
	}

	public void deleteInBatch(Iterable<Categorie> entities) {
		categorieRepository.deleteInBatch(entities);
	}

	public <S extends Categorie> Page<S> findAll(Example<S> example, Pageable pageable) {
		return categorieRepository.findAll(example, pageable);
	}

	public void deleteAllInBatch() {
		categorieRepository.deleteAllInBatch();
	}

	public Categorie getOne(Long id) {
		return categorieRepository.getOne(id);
	}

	public <S extends Categorie> long count(Example<S> example) {
		return categorieRepository.count(example);
	}

	public <S extends Categorie> boolean exists(Example<S> example) {
		return categorieRepository.exists(example);
	}

	public <S extends Categorie> List<S> findAll(Example<S> example) {
		return categorieRepository.findAll(example);
	}

	public long count() {
		return categorieRepository.count();
	}

	public void deleteById(Long id) {
		categorieRepository.deleteById(id);
	}

	public <S extends Categorie> List<S> findAll(Example<S> example, Sort sort) {
		return categorieRepository.findAll(example, sort);
	}

	public void delete(Categorie entity) {
		categorieRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Categorie> entities) {
		categorieRepository.deleteAll(entities);
	}

	public void deleteAll() {
		categorieRepository.deleteAll();
	}
	
	
	
}
