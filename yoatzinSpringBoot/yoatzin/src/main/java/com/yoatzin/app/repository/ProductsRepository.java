package com.yoatzin.app.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Products;

public interface ProductsRepository extends CrudRepository<Products, Long> {
	
	Optional<Products> findByName(String name);
	Optional<Products> findByCategory(String category);
	Optional<Products> findByPrice(BigDecimal price);
	Optional<Products> findByOrigin(String origin);
	Optional<Products> findByStock(int stock);

}

