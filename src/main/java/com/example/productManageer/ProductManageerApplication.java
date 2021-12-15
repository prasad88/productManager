package com.example.productManageer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.productManageer.models"}) 
public class ProductManageerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManageerApplication.class, args);
	}

}
