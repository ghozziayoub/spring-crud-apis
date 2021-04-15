package com.formalab.ecom.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.formalab.ecom.entities.Utilisateur;
import com.formalab.ecom.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {

		@Autowired
		UtilisateurRepository utilisateurRepository ;
		
		@Autowired
		BCryptPasswordEncoder bCryptPasswordEncoder ;
		
		
		public <S extends Utilisateur> S register (S entity) {
			String hashPW=bCryptPasswordEncoder.encode(entity.getPassword());
			entity.setPassword(hashPW);
			entity.setRole("client");
			return utilisateurRepository.save(entity);
		}
		

	

		public Utilisateur findByEmail(String email) {
			return utilisateurRepository.findByEmail(email);
		}




		public <S extends Utilisateur> S save(S entity) {
			return utilisateurRepository.save(entity);
		}

		public <S extends Utilisateur> Optional<S> findOne(Example<S> example) {
			return utilisateurRepository.findOne(example);
		}

		public Page<Utilisateur> findAll(Pageable pageable) {
			return utilisateurRepository.findAll(pageable);
		}

		public List<Utilisateur> findAll() {
			return utilisateurRepository.findAll();
		}

		public List<Utilisateur> findAll(Sort sort) {
			return utilisateurRepository.findAll(sort);
		}

		public List<Utilisateur> findAllById(Iterable<Long> ids) {
			return utilisateurRepository.findAllById(ids);
		}

		public <S extends Utilisateur> List<S> saveAll(Iterable<S> entities) {
			return utilisateurRepository.saveAll(entities);
		}

		public Optional<Utilisateur> findById(Long id) {
			return utilisateurRepository.findById(id);
		}

		public void flush() {
			utilisateurRepository.flush();
		}

		public <S extends Utilisateur> S saveAndFlush(S entity) {
			return utilisateurRepository.saveAndFlush(entity);
		}

		public boolean existsById(Long id) {
			return utilisateurRepository.existsById(id);
		}

		public void deleteInBatch(Iterable<Utilisateur> entities) {
			utilisateurRepository.deleteInBatch(entities);
		}

		public <S extends Utilisateur> Page<S> findAll(Example<S> example, Pageable pageable) {
			return utilisateurRepository.findAll(example, pageable);
		}

		public void deleteAllInBatch() {
			utilisateurRepository.deleteAllInBatch();
		}

		public Utilisateur getOne(Long id) {
			return utilisateurRepository.getOne(id);
		}

		public <S extends Utilisateur> long count(Example<S> example) {
			return utilisateurRepository.count(example);
		}

		public <S extends Utilisateur> boolean exists(Example<S> example) {
			return utilisateurRepository.exists(example);
		}

		public <S extends Utilisateur> List<S> findAll(Example<S> example) {
			return utilisateurRepository.findAll(example);
		}

		public long count() {
			return utilisateurRepository.count();
		}

		public void deleteById(Long id) {
			utilisateurRepository.deleteById(id);
		}

		public <S extends Utilisateur> List<S> findAll(Example<S> example, Sort sort) {
			return utilisateurRepository.findAll(example, sort);
		}

		public void delete(Utilisateur entity) {
			utilisateurRepository.delete(entity);
		}

		public void deleteAll(Iterable<? extends Utilisateur> entities) {
			utilisateurRepository.deleteAll(entities);
		}

		public void deleteAll() {
			utilisateurRepository.deleteAll();
		} 
		
}
