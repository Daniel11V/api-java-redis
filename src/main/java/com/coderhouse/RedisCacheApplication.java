package com.coderhouse;

import com.coderhouse.model.*;
import com.coderhouse.repository.CategoryRepository;
import com.coderhouse.repository.RestauranteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class RedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(RestauranteRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {
			Category elegante = new Category("cat");
			categoryRepository.save(elegante);
			Category pizza = new Category("dog");
			categoryRepository.save(pizza);

			repository.save(Restaurante.builder().id(2L).nombre("Esteban").ciudad(new City("BBAA", new Country("Arg"))).build());
			repository.save(Restaurante.builder().id(3L).nombre("Juan").ciudad(new City("BBAA", new Country("Arg"))).build());
			repository.save(Restaurante.builder().id(4L).nombre("Matias").ciudad(new City("BBAA", new Country("Arg"))).build());
			repository.save(Restaurante.builder().id(5L).nombre("Ninaaa").ciudad(new City("BBAA", new Country("Arg"))).build());
			repository.save(Restaurante.builder().id(6L).nombre("Camila").ciudad(new City("BBAA", new Country("Arg"))).build());
			repository.save(Restaurante.builder().id(7L).nombre("Josee").categorias(Arrays.asList(elegante, pizza)).ciudad(new City("BBAA", new Country("Arg"))).build());
		};
	}

}
