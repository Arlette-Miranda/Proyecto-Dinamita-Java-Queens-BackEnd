package com.yoatzin.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoatzin.app.model.Products;
import com.yoatzin.app.service.ProductsService;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin(origins = "*")
public class ProductsController {
	
	ProductsService productsService;

	public ProductsController(ProductsService productsService) {
		this.productsService = productsService;
	}
	
	//Método para crear un nuevo producto
	@PostMapping
    public ResponseEntity<Products> createProducts(@RequestBody Products products) {
        Products newProducts = productsService.createProducts(products);
        return ResponseEntity.status(201).body(newProducts);
    }
	
	// Método para obtener un producto por ID
    @GetMapping("{id}") // api/v1/products/10
    public ResponseEntity<Products> getProductsById(@PathVariable("id") Long id) {
        Products existingProduct = productsService.getProductsById(id);
        return ResponseEntity.ok(existingProduct);
    }
	
    // Método para actualizar un producto
    @PutMapping("{id}")
    public ResponseEntity<Products> updateProducts(@RequestBody Products newProductData, @PathVariable("id") Long id) {
        Products updatedProducts = productsService.updateProducts(newProductData, id);
        return ResponseEntity.ok(updatedProducts);
    }
    
    // Método para eliminar un producto
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProducts(@PathVariable("id") Long id) {
        productsService.deleteProducts(id);
        return ResponseEntity.status(204).body("Product id " + id + " successfully deleted");
    }
    
}
