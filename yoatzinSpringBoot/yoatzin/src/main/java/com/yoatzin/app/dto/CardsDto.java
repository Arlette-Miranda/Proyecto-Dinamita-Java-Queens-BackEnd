package com.yoatzin.app.dto;

public class CardsDto {
	
	private Long number;
	private Long owner_card;
	private Long month;
	private Long year;
	private Long cvc;
	
	public CardsDto() {}

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
	
}
