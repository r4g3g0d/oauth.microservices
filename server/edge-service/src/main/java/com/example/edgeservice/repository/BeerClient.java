package com.example.edgeservice.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.edgeservice.domain.Beer;

@FeignClient("beer-catalog-service")
public interface BeerClient {
	 @GetMapping("/beer-list")
	 Resources<Beer> readBeers();
	 
//	 @GetMapping("/test")
//	 Resources<Beer> readTest();
}
