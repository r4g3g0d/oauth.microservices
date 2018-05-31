package com.example.beercatalogservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.beercatalogservice.domain.Beer;
import com.example.beercatalogservice.repository.BeerRepository;



@RestController
public class TestController {
	@Autowired
	private BeerRepository beerRepo;
	
	@GetMapping("/test")
	public Resources<Beer> getBieer() {
		ArrayList<Beer> list = (ArrayList<Beer>) beerRepo.findAll();
		System.out.println(list.toString());
		Resources<Beer> beerList= new Resources<Beer> (list);
		System.out.println("BeerList" + beerList.toString());
		return beerList;
	 }
}
