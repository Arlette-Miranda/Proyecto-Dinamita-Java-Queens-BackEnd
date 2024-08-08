package com.yoatzin.app.model;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="products")

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduct;
	
	@ManyToOne
	@JoinColumn(name= "fk_id_size")
	private Size size;
	
	@Column(name="name", length=45, nullable=false)
	private String name;
	@Column(name="category", length=45, nullable=false)
	private String category;
	@Column(name="price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;
	@Column(name="image", length=250, nullable=false)
	private String image;
	@Column(name="origin", length=70, nullable=true)
	private String origin;
	@Column(name="stock", nullable=false)
	private int stock;
	@Column(name="description", columnDefinition = "LONGTEXT", nullable=true)
	private String description;
	
	public Product() {
		
	}

	public Product(String name, String category, BigDecimal price, String image, String origin, int stock,
			String description, Size size) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
		this.origin = origin;
		this.stock = stock;
		this.description = description;
		this.size = size;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long id_product) {
		this.idProduct = id_product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id_product=");
		builder.append(idProduct);
		builder.append(", fk_id_size=");
		builder.append(size);
		builder.append(", name=");
		builder.append(name);
		builder.append(", category=");
		builder.append(category);
		builder.append(", price=");
		builder.append(price);
		builder.append(", image=");
		builder.append(image);
		builder.append(", origin=");
		builder.append(origin);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
}
