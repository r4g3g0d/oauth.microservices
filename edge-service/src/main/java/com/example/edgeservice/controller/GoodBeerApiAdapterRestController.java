package com.example.edgeservice.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.edgeservice.domain.Beer;
import com.example.edgeservice.repository.BeerClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class GoodBeerApiAdapterRestController {
	@Autowired
	private BeerClient beerClient;

//	public GoodBeerApiAdapterRestController(BeerClient beerClient) {
//		this.beerClient = beerClient;
//	    }
	
	public Collection<Beer> fallback() {
		//System.out.println("[fallback]" + beerClient.readBeers());
		return new ArrayList<>();
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	@GetMapping("/good-beers")
	@CrossOrigin(origins="*")
	public Collection<Beer> goodBeers() {
		System.out.println("[good-beers]" + beerClient.readBeers());
		return beerClient.readBeers()
				.getContent()
	            .stream()
	            .filter(this::isGreat)
	            .collect(Collectors.toList());
	    }

	private boolean isGreat(Beer beer) {
		System.out.println(beer.toString());
	    return !beer.getName().equals("Budweiser") &&
	           !beer.getName().equals("Coors Light") &&
	           !beer.getName().equals("PBR");
	    }
	/*	@CrossOrigin(origins="*")
		@HystrixCommand(fallbackMethod="fallback")
	    @GetMapping("/test-beers")
	    private Collection<Beer> testBeers() { 
			System.out.println(beerClient.readTest());
	    	return beerClient.readTest().getContent()
	                .stream().collect(Collectors.toList());
	    }*/
}
