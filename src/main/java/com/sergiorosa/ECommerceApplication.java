package com.sergiorosa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sergiorosa.domain.Categorie;
import com.sergiorosa.domain.City;
import com.sergiorosa.domain.Product;
import com.sergiorosa.domain.State;
import com.sergiorosa.repositories.CategoryRepository;
import com.sergiorosa.repositories.CityRepository;
import com.sergiorosa.repositories.ProductRepository;
import com.sergiorosa.repositories.StateRepository;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categorie cat1 = new Categorie(null, "Computer");
		Categorie cat2 = new Categorie(null, "Mac Book Apple Computer");
		
		Product p1 = new Product(null, "Computer", 1800.00);
		Product p2 = new Product(null, "MacBook",  2800.00);
		Product p3 = new Product(null, "Ipad",     400.00);
		
		cat1.getProdut().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdut().addAll(Arrays.asList( p2 ));
		
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		State  sta1 = new State(null, "Boston");
		State  sta2 = new State(null, "Broklyn");
		
		City c1 = new City(null, "Massachusetts", sta1);
		City c2 = new City(null, "New York", sta2);
		City c3 = new City(null, "California", sta2);
		
		sta1.getCities().addAll(Arrays.asList(c1));
		sta2.getCities().addAll(Arrays.asList(c2,c3));
		
		stateRepository.saveAll(Arrays.asList(sta1, sta2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
		
		
	}
}
