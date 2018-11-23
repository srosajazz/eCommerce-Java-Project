package com.sergiorosa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sergiorosa.domain.Categorie;
import com.sergiorosa.repositories.CategoryRepository;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categorie cat1 = new Categorie(null, "Computer");
		Categorie cat2 = new Categorie(null, "Apple computer");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
	}
}
