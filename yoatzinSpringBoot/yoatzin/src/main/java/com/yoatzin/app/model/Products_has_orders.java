package com.yoatzin.app.model;import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="products_has_orders")

public class Products_has_orders {
	@Id
	private Long id_product;
	
	private Long id_order;
	
	@Column(name="partial_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal partial_amount;
	@Column(name="discount", precision = 10, scale = 2, nullable = false)
    private BigDecimal discount;
	@Column(name="shipment", precision = 10, scale = 2, nullable = false)
    private BigDecimal shipment;
	@Column(name="final_amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal final_amount;
	
	public Products_has_orders() {
		
	}

	public Products_has_orders(BigDecimal partial_amount, BigDecimal discount, BigDecimal shipment,
			BigDecimal final_amount) {
		super();
		this.partial_amount = partial_amount;
		this.discount = discount;
		this.shipment = shipment;
		this.final_amount = final_amount;
	}

	public Long getId_product() {
		return id_product;
	}

	public void setId_product(Long id_product) {
		this.id_product = id_product;
	}

	public Long getId_order() {
		return id_order;
	}

	public void setId_order(Long id_order) {
		this.id_order = id_order;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Products_has_orders [id_product=");
		builder.append(id_product);
		builder.append(", id_order=");
		builder.append(id_order);
		builder.append(", partial_amount=");
		builder.append(partial_amount);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", shipment=");
		builder.append(shipment);
		builder.append(", final_amount=");
		builder.append(final_amount);
		builder.append("]");
		return builder.toString();
	}
	

}
