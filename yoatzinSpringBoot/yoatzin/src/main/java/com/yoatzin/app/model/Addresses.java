package com.yoatzin.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="adresses")

public class Addresses {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long fk_id_user;
	
	@Column(name="state", length=20, nullable=false)
	private String state;
	@Column(name="city", length=50, nullable=false)
	private String city;
	@Column(name="colony", length=50, nullable=false)
	private String colony;
	@Column(name="street", length=50, nullable=false)
	private String street;
	@Column(name="zipcode", length=5, nullable=false)
	private String zipcode;
	@Column(name="reference", length=45, nullable=true)
	private String reference;
	
	public Addresses() {
		
	}

	public Addresses(String state, String city, String colony, String street, String zipcode, String reference) {
		super();
		this.state = state;
		this.city = city;
		this.colony = colony;
		this.street = street;
		this.zipcode = zipcode;
		this.reference = reference;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFk_id_user() {
		return fk_id_user;
	}

	public void setFk_id_user(Long fk_id_user) {
		this.fk_id_user = fk_id_user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Addresses [id=");
		builder.append(id);
		builder.append(", fk_id_user=");
		builder.append(fk_id_user);
		builder.append(", state=");
		builder.append(state);
		builder.append(", city=");
		builder.append(city);
		builder.append(", colony=");
		builder.append(colony);
		builder.append(", street=");
		builder.append(street);
		builder.append(", zipcode=");
		builder.append(zipcode);
		builder.append(", reference=");
		builder.append(reference);
		builder.append("]");
		return builder.toString();
	}
	
}
