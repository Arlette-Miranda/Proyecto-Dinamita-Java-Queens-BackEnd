package com.yoatzin.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="cards")

public class Cards {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_card;
	
	private Long fk_id_user;
	@Column(name="number", length=16, nullable=false)
	private String number;
	@Column(name="owner_card", length=100, nullable=false)
	private String owner_card;
	@Column(name="month", length=2, nullable=false)
	private String month;
	@Column(name="year", length=4, nullable=false)
	private String year;
	@Column(name="cvc", length=4, nullable=false)
	private String cvc;
	
	public Cards() {
		
	}

	public Cards(String number, String owner_card, String month, String year, String cvc) {
		super();
		this.number = number;
		this.owner_card = owner_card;
		this.month = month;
		this.year = year;
		this.cvc = cvc;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOwner_card() {
		return owner_card;
	}

	public void setOwner_card(String owner_card) {
		this.owner_card = owner_card;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cards [id_card=");
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
		builder.append("]");
		return builder.toString();
	}
	
	
}
