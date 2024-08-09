package com.yoatzin.app.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name ="addresses")

public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_address; 
	
	//Se crea lleve foranea
	@ManyToOne
	@JoinColumn(name = "fk_id_user")
	@JsonIgnoreProperties({"name","lastName", "phone","email","password"})
	private User user;
	
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
	
	public Address() {}

	//Se agrega User user por Fk en atributos
	public Address(String state, String city, String colony, String street, String zipcode, String reference, User user) {
		this.state = state;
		this.city = city;
		this.colony = colony;
		this.street = street;
		this.zipcode = zipcode;
		this.reference = reference;
		this.user = user; // Se agrega por llave foranea
	}
	
	public Long getId_address() {
		return id_address;
	}

	public void setId_address(Long id_address) {
		this.id_address = id_address;
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
	
	// Se agregan Get y Set de Fk
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id_address=");
		builder.append(id_address);
		builder.append(", fk_id_user=");
		builder.append(user); // se cambia a user por Fk
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
