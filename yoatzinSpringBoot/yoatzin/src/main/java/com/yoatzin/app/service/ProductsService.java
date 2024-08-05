package com.yoatzin.app.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Products;

@Service
public interface ProductsService {
	Products createProducts(Products products);
	Products getProductsById(Long id);
	Products getProductsByName(String name);
	Products getProductsByCategory(String category);
	Products getProductsByPrice(BigDecimal price);
	Products getProductsByStock(int stock);
	Products updateProducts(Products products, Long id);
	void deleteProducts(Long id);
	
	

}
