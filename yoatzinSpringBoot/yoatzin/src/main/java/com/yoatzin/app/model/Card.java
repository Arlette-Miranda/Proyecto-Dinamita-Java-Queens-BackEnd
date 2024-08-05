package com.yoatzin.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="cards")

public class Card {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_card;
	
	private Long fk_id_user;
	@Column(name="number", length=16, nullable=false)
	private Long number;
	@Column(name="owner_card", length=100, nullable=false)
	private Long owner_card;
	@Column(name="month", length=2, nullable=false)
	private Long month;
	@Column(name="year", length=4, nullable=false)
	private Long year;
	@Column(name="cvc", length=4, nullable=false)
	private Long cvc;
	private boolean active;
	
	public Card() {
		
	}

	public Card(Long number, Long owner_card, Long month, Long year, Long cvc, boolean active) {
		super();
		this.number = number;
		this.owner_card = owner_card;
		this.month = month;
		this.year = year;
		this.cvc = cvc;
		this.active = active;
	}

	public Long getId_card() {
		return id_card;
	}

	public void setId_card(Long id_card) {
		this.id_card = id_card;
	}

	public Long getFk_id_user() {
		return fk_id_user;
	}

	public void setFk_id_user(Long fk_id_user) {
		this.fk_id_user = fk_id_user;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getOwner_card() {
		return owner_card;
	}

	public void setOwner_card(Long owner_card) {
		this.owner_card = owner_card;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getCvc() {
		return cvc;
	}

	public void setCvc(Long cvc) {
		this.cvc = cvc;
	}
    
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [id_card=");
		builder.append(id_card);
		builder.append(", fk_id_user=");
		builder.append(fk_id_user);
		builder.append(", number=");
		builder.append(number);
		builder.append(", owner_card=");
		builder.append(owner_card);
		builder.append(", month=");
		builder.append(month);
		builder.append(", year=");
		builder.append(year);
		builder.append(", cvc=");
		builder.append(cvc);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
	}

	
}
