package com.yoatzin.app.model;import java.io.Serializable;
import java.math.BigDecimal;

import com.yoatzin.app.model.composite_key.ProductOrderKey;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name ="products_has_orders")

public class ProductHasOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProductOrderKey id;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@MapsId("orderId")
	@JoinColumn(name = "order_id")
	private Order order;
	
	@Column(name="partial_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal partial_amount;
	@Column(name="discount", precision = 10, scale = 2, nullable = false)
    private BigDecimal discount;
	@Column(name="shipment", precision = 10, scale = 2, nullable = false)
    private BigDecimal shipment;
	@Column(name="final_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal final_amount;
	
	public ProductHasOrder() {
		
	}

	public ProductHasOrder(ProductOrderKey id, Product product, Order order, BigDecimal partial_amount,
			BigDecimal discount, BigDecimal shipment, BigDecimal final_amount) {
		this.id = id;
		this.product = product;
		this.order = order;
		this.partial_amount = partial_amount;
		this.discount = discount;
		this.shipment = shipment;
		this.final_amount = final_amount;
	}

	public ProductOrderKey getId() {
		return id;
	}

	public void setId(ProductOrderKey id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getPartial_amount() {
		return partial_amount;
	}

	public void setPartial_amount(BigDecimal partial_amount) {
		this.partial_amount = partial_amount;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getShipment() {
		return shipment;
	}

	public void setShipment(BigDecimal shipment) {
		this.shipment = shipment;
	}

	public BigDecimal getFinal_amount() {
		return final_amount;
	}

	public void setFinal_amount(BigDecimal final_amount) {
		this.final_amount = final_amount;
	}
	

}
