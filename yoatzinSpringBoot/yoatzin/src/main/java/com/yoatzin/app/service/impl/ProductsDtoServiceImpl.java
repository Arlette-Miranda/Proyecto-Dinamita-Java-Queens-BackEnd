package com.yoatzin.app.service.impl;

import com.yoatzin.app.dto.ProductsDto;
import com.yoatzin.app.model.Products;
import com.yoatzin.app.service.ProductsDtoService;
import com.yoatzin.app.service.ProductsService;

public class ProductsDtoServiceImpl implements ProductsDtoService {
	
	ProductsService productsService;
	
	public ProductsDtoServiceImpl(ProductsService productsService) {
		this.productsService = productsService;
	}

	@Override
	public ProductsDto createProducts(Products products) {
		Products newProducts = productsService.createProducts( products);
		ProductsDto newProductsDto = new ProductsDto();
		newProductsDto.setSerialNumber(newProducts.getId_product());
		newProductsDto.setName(newProducts.getName());
		newProductsDto.setCategory(newProducts.getCategory());
		newProductsDto.setOrigin(newProducts.getOrigin());
		newProductsDto.setStock(newProducts.getStock() );
		newProductsDto.setDescription(newProducts.getDescription());
		
		return newProductsDto;
		
	}

	@Override
	public ProductsDto getProductsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductsDto getProductsByname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductsDto getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductsDto getProductsByStock(int stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductsDto updateProducts(Products products, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProducts(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductsDto getProductsByOrigin(String origin) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
