package com.sergiorosa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sergiorosa.domain.Address;
import com.sergiorosa.domain.Categorie;
import com.sergiorosa.domain.City;
import com.sergiorosa.domain.Client;
import com.sergiorosa.domain.Product;
import com.sergiorosa.domain.State;
import com.sergiorosa.domain.enums.ClientType;
import com.sergiorosa.repositories.AddressRepository;
import com.sergiorosa.repositories.CategoryRepository;
import com.sergiorosa.repositories.CityRepository;
import com.sergiorosa.repositories.ClientRepository;
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

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categorie cat1 = new Categorie(null, "Computer");
		Categorie cat2 = new Categorie(null, "Mac Book Apple Computer");

		Product p1 = new Product(null, "Computer", 1800.00);
		Product p2 = new Product(null, "MacBook", 2800.00);
		Product p3 = new Product(null, "Ipad", 400.00);

		cat1.getProdut().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdut().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		State sta1 = new State(null, "Boston");
		State sta2 = new State(null, "Broklyn");

		City c1 = new City(null, "Massachusetts", sta1);
		City c2 = new City(null, "New York", sta2);
		City c3 = new City(null, "California", sta2);

		sta1.getCities().addAll(Arrays.asList(c1));
		sta2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(sta1, sta2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Mike Smith", "msmith@gmail.com", "63789300", ClientType.PHYSICALPERSON);

		cli1.getPhones().addAll(Arrays.asList("536383839", "9202938930"));

		Address a1 = new Address(null, "Main St", "777", "Apt 256", "Malden", "02678", cli1, c1);
		Address a2 = new Address(null, "Lowes St", "657", "Apt 67", "Downtown", "07865", cli1, c2);

		cli1.getAdresses().addAll(Arrays.asList(a1, a2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));

	}
}
