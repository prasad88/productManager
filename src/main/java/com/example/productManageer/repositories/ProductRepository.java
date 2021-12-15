package com.example.productManageer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.productManageer.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

	
}
