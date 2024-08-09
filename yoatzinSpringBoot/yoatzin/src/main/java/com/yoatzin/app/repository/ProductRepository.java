package com.yoatzin.app.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Optional<Product> findByName(String name);
	Optional<Product> findByCategory(String category);
	Optional<Product> findByPrice(BigDecimal price);
	Optional<Product> findByOrigin(String origin);
	Optional<Product> findByStock(int stock);

}

