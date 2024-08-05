package com.yoatzin.app.util;

import java.util.ArrayList;
import java.util.List;

import com.yoatzin.app.model.Products;

public class ProductsGenerator {
	
	private ProductsGenerator() {}
	
	public static List<Products> generateRandomProducts(int quantity) {
        List<Products> products = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            products.add(generateRandomProduct());
        }

        return products;
    }

	private static Products generateRandomProduct() {
		return null;
	}


}
