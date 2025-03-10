package com.example.restful_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.restful_api.model.Item;
import com.example.restful_api.repository.ItemRepository;

@SpringBootApplication
public class RestfulApiApplication {

	private static final Logger log = LoggerFactory.getLogger(RestfulApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestfulApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner testJPATemplate(ItemRepository repo){
		return (args) -> {
			repo.save(new Item("Item 1", "Games"));
			repo.save(new Item("Item 2", "Sports"));
			repo.save(new Item("Item 3", "Magazines"));
			repo.save(new Item("Item 4", "Racing Games"));
			repo.save(new Item("Item 5", "Movies"));
			log.info("Items found with findAll():");
			log.info("-------------------------------");

			for (Item item : repo.findAll()) {
				log.info(item.toString());
			}

			Item res = repo.findById(3);
			log.info("Item found with findById(3):");
			log.info("--------------------------------");
			log.info(res.toString());

			log.info("Items found with findByDescription('Games'):");
			log.info("--------------------------------");
			repo.findByDescription("Games").forEach(item -> {
				log.info(item.toString());
			});
			log.info("End of demonstration.");
			log.info("--------------------------------");
		};
	}
}
