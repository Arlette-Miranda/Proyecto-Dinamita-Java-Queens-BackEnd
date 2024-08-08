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

import com.yoatzin.app.model.Product;
import com.yoatzin.app.service.ProductService;

@RestController
@RequestMapping("api/v1/products")
@CrossOrigin(origins = "*")
public class ProductController {
	
	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//Método para crear un nuevo producto
	@PostMapping
    public ResponseEntity<Product> createProducts(@RequestBody Product product) {
        Product newProducts = productService.createProducts(product);
        return ResponseEntity.status(201).body(newProducts);
    }
	
	// Método para obtener un producto por ID
    @GetMapping("{id}") // api/v1/products/10
    public ResponseEntity<Product> getProductsById(@PathVariable("id") Long id) {
        Product existingProduct = productService.getProductsById(id);
        return ResponseEntity.ok(existingProduct);
    }
	
    // Método para actualizar un producto
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProducts(@RequestBody Product newProductData, @PathVariable("id") Long id) {
        Product updatedProducts = productService.updateProducts(newProductData, id);
        return ResponseEntity.ok(updatedProducts);
    }
    
    // Método para eliminar un producto
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProducts(@PathVariable("id") Long id) {
        productService.deleteProducts(id);
        return ResponseEntity.status(204).body("Product id " + id + " successfully deleted");
    }
    
}
