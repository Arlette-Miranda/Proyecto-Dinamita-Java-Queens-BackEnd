package com.yoatzin.app.util;

import com.yoatzin.app.model.Product;

public class ProductUpdater {
	
	private ProductUpdater() {}

	public static Product updateProducts(Product existingProduct, Product newProductData) {
		if (existingProduct == null || newProductData == null) {
            throw new IllegalArgumentException("Product data cannot be null");
        }
		
		existingProduct.setName(newProductData.getName());
		existingProduct.setCategory(newProductData.getCategory());
		existingProduct.setPrice(newProductData.getPrice());
		existingProduct.setImage(newProductData.getImage());
		existingProduct.setOrigin(newProductData.getOrigin());
		existingProduct.setStock(newProductData.getStock());
		existingProduct.setDescription(newProductData.getDescription());
		
		return existingProduct;
		
	}

}
