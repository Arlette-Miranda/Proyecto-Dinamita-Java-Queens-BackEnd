package com.yoatzin.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="sizes")

public class Sizes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_size;
	
	@Column(name="size", length=10, nullable=false)
	private String size;
	
	public Sizes() {
		
	}

	public Sizes(String size) {
		super();
		this.size = size;
	}

	public Long getId_size() {
		return id_size;
	}

	public void setId_size(Long id_size) {
		this.id_size = id_size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sizes [id_size=");
		builder.append(id_size);
		builder.append(", size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
	}
	
}
