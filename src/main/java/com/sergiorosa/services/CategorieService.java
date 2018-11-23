package com.sergiorosa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergiorosa.domain.Categorie;
import com.sergiorosa.repositories.CategoryRepository;

@Service
public class CategorieService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Categorie find(Integer id) { 
		Optional<Categorie> obj = repo.findById(id); 
		return obj.orElse(null);
	}

}
