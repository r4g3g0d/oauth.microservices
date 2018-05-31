package com.example.beercatalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.beercatalogservice.domain.Beer;

@RepositoryRestResource
public interface BeerRepository extends JpaRepository<Beer, Long> {

}
