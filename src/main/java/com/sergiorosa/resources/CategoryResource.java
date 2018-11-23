package com.sergiorosa.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sergiorosa.domain.Categorie;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categorie> list() { 
		
		Categorie cat1 = new Categorie(1, "Computer");
		Categorie cat2 = new Categorie(2, "Printer 300A");
		
		List<Categorie> list = new ArrayList<>();
		list.add(cat1);
		list.add(cat2);
		
		
		return list;
	}

}
