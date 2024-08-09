package com.yoatzin.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoatzin.app.model.ProductHasOrder;
import com.yoatzin.app.service.ProductHasOrderService;

@RestController
@RequestMapping("api/v1/product-has-order")
@CrossOrigin(origins ="*")
public class ProductHasOrderController {
	
	ProductHasOrderService prHorService;

	public ProductHasOrderController(ProductHasOrderService prHorService) {
		super();
		this.prHorService = prHorService;
	}
	
	@PostMapping 
	public ResponseEntity<ProductHasOrder> createOrderHasProduct(@RequestBody ProductHasOrder productHasOrder){
		ProductHasOrder savedOrderHasProduct = prHorService.createProductHasOrder(productHasOrder);
		return ResponseEntity.status(201).body(savedOrderHasProduct);
	}
	
	@GetMapping
	public ResponseEntity< Iterable<ProductHasOrder>> getAllProductHasOrder() {
		Iterable<ProductHasOrder> orderHasProduct = prHorService.getProductHasOrder();
		return ResponseEntity.ok(orderHasProduct);
	}
	
	@GetMapping("/query") // localhost:8080/api/v1/product-has-order/query?productId=1&orderId=3 
	public ResponseEntity< ProductHasOrder> getProductHasOrderByCompositeId(
			@RequestParam(name = "productId") Long productId,
			@RequestParam(name = "orderId") Long orderId
			) {
		ProductHasOrder orderHasProduct = prHorService.getProductHasOrderByCompositeId(productId, orderId);
		return ResponseEntity.ok(orderHasProduct);
	}
	
	@GetMapping("/product/{id}") // localhost:8080/api/v1/product-has-order/product/1
	public ResponseEntity< Iterable<ProductHasOrder>> getProductHasOrderByProductId(
			@PathVariable("id") Long productId
			) {
		Iterable<ProductHasOrder> orderHasProduct = prHorService.getProductHasOrderByProductId(productId);
		return ResponseEntity.ok(orderHasProduct);
	}

	

}
