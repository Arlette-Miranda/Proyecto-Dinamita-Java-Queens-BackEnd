package com.yoatzin.app.model.composite_key;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Component
@Embeddable
public class ProductOrderKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column( name = "product_id")
	Long productId;
	@Column( name = "order_id")
	Long orderId;
	
	public ProductOrderKey() {}

	public ProductOrderKey(Long productId, Long orderId) {
		this.productId = productId;
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	

}
