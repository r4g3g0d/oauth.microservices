package com.example.beercatalogservice.initializer;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.beercatalogservice.domain.Beer;
import com.example.beercatalogservice.repository.BeerRepository;
@Component
class BeerInitializer implements CommandLineRunner {

	private final BeerRepository beerRepository;

    BeerInitializer(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light", "PBR")
                .forEach(beer -> beerRepository.save(new Beer(beer)));
        System.out.println("???Intra aici???");
        beerRepository.findAll().forEach(System.out::println);
        
    }

}
