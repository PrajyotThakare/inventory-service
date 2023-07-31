package com.prajyot.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.prajyot.inventory.entity.Inventory;
import com.prajyot.inventory.repository.InventoryRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository repository) {
		return args -> {
			repository.deleteAll();
			Inventory inventory1 = new Inventory();
			inventory1.setQty(7);
			inventory1.setSkuCode("iphone 13");
			
			Inventory inventory2 = new Inventory();
			inventory2.setQty(3);
			inventory2.setSkuCode("iphone 14");
			
			repository.save(inventory1);
			repository.save(inventory2);
		};
		
	}
}
