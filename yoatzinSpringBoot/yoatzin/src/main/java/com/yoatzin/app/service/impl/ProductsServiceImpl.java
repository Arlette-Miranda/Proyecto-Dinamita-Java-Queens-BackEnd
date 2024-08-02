package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Products;
import com.yoatzin.app.repository.ProductsRepository;
import com.yoatzin.app.service.ProductsService;
import com.yoatzin.app.util.ProductsUpdater;

@Service
public class ProductsServiceImpl implements ProductsService {
    
    //@Autowired
    ProductsRepository productsRepository;
    
    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    
    @Override
    public Products createProducts(Products products) {
    	products.setId_product(null);
        Products newProducts = saveProducts(products);
        return newProducts;
    }
    
    private Products saveProducts(Products products) {
    	return productsRepository.save(products);
    }

	@Override
	public Products getProductsById(Long id) {
		Optional<Products> optionalProduct = productsRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Product does not exist with id " + id);
        }
        return optionalProduct.get();
	}

	@Override
	public Products getProductsByCategory(String category) {
		Optional<Products> optionalProduct = productsRepository.findByCategory(category);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Product does not exist with category " + category);
        }
        return optionalProduct.get();
	}

	@Override
	public Products getProductsByStock(int stock) {
		Optional<Products> optionalProduct = productsRepository.findByStock(stock);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Product does not exist with stock " + stock);
        }
        return optionalProduct.get();
	}

	@Override
	public Products updateProducts(Products newProductsData, Long id) {
		Products existingProduct = getProductsById(id);
        return ProductsUpdater.updateProducts(existingProduct, newProductsData);
	}

	@Override
	public void deleteProducts(Long id) {
		Products existingProduct = getProductsById(id);
		saveProducts(existingProduct);
	}

	@Override
	public Products getProductsByName(String name) {
		Optional<Products> optionalProduct = productsRepository.findByName(name);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Product does not exist with name " + name);
        }
        return optionalProduct.get();
	}
}
