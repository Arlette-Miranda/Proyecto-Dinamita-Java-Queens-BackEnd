package com.yoatzin.app.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Product;

@Service
public interface ProductService {
	Product createProducts(Product product);
	Product getProductsById(Long id);
	Product getProductsByName(String name);
	Product getProductsByCategory(String category);
	Product getProductsByPrice(BigDecimal price);
	Product getProductsByStock(int stock);
	Product updateProducts(Product product, Long id);
	void deleteProducts(Long id);
	
	

}
