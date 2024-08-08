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
@Table(name ="cards")

public class Card {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_card;
	
	// Se crea lleve foranea
		@ManyToOne
		@JoinColumn(name = "fk_id_user")
		@JsonIgnoreProperties({"name","lastName", "phone","email","password"})
		private User user;
	
	@Column(name="number", length=16, nullable=false)
	private String number;
	@Column(name="ownerCard", length=100, nullable=false)
	private String ownerCard;
	@Column(name="month", length=2, nullable=false)
	private String month;
	@Column(name="year", length=4, nullable=false)
	private String year;
	@Column(name="cvc", length=4, nullable=false)
	private String cvc;
	
	public Card() {}
	
	//Se agrega User user por Fk en atributos
	public Card(String number, String ownerCard, String month, String year, String cvc, User user) {
		super();
		this.number = number;
		this.ownerCard = ownerCard;
		this.month = month;
		this.year = year;
		this.cvc = cvc;
		this.user = user; // Se agrega por llave foranea
	}

	public Long getId_card() {
		return id_card;
	}

	public void setId_card(Long id_card) {
		this.id_card = id_card;
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOwnerCard() {
		return ownerCard;
	}

	public void setOwnerCard(String ownerCard) {
		this.ownerCard = ownerCard;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
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
		builder.append("Card [id_card=");
		builder.append(id_card);
		builder.append(", fk_id_user=");
		builder.append(user);
		builder.append(", number=");
		builder.append(number);
		builder.append(", ownerCard=");
		builder.append(ownerCard);
		builder.append(", month=");
		builder.append(month);
		builder.append(", year=");
		builder.append(year);
		builder.append(", cvc=");
		builder.append(cvc);
		builder.append("]");
		return builder.toString();
	}

	
}
