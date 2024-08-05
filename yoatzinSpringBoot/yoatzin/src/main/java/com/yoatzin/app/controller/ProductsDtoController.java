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

import com.yoatzin.app.dto.ProductsDto;
import com.yoatzin.app.model.Products;
import com.yoatzin.app.service.ProductsDtoService;

@RestController
@RequestMapping("api/v2/products")
@CrossOrigin(origins = "*")
public class ProductsDtoController {
	
	ProductsDtoService productsDtoService;

	public ProductsDtoController(ProductsDtoService productsDtoService) {
		this.productsDtoService = productsDtoService;
	}
	
	//Método para crear un nuevo producto
	@PostMapping
    public ResponseEntity<ProductsDto> createProducts(@RequestBody Products products) {
        ProductsDto newProducts = productsDtoService.createProducts(products);
        return ResponseEntity.status(201).body(newProducts);
    }
	
	// Método para obtener un producto por ID
    @GetMapping("{id}") // api/v1/products/10
    public ResponseEntity<ProductsDto> getProductsById(@PathVariable("id") Long id) {
        ProductsDto existingProduct = productsDtoService.getProductsById(id);
        return ResponseEntity.ok(existingProduct);
    }
	
    // Método para actualizar un producto
    @PutMapping("{id}")
    public ResponseEntity<ProductsDto> updateProduct(@RequestBody Products newProductData, @PathVariable("id") Long id) {
        ProductsDto updatedProduct = productsDtoService.updateProducts(newProductData, id);
        return ResponseEntity.ok(updatedProduct);
    }

    
    // Método para eliminar un producto
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProducts(@PathVariable("id") Long id) {
        productsDtoService.deleteProducts(id);
        return ResponseEntity.status(204).body("Product id " + id + " successfully deleted");
    }
    

}
