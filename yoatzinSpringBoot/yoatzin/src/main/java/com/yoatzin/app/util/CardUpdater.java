package com.yoatzin.app.util;

import com.yoatzin.app.model.Card;

public final class CardUpdater {
	
	private CardUpdater(){}
	
		public static Card updateCards(Card existingCard, Card newCardData) {
			if (existingCard == null || newCardData == null) {
				throw new IllegalArgumentException("Card data cannot be null");
			}
			
			existingCard.setId_card(newCardData.getId_card());
			existingCard.setNumber(newCardData.getNumber());
			existingCard.setOwnerCard(newCardData.getOwnerCard());
			existingCard.setMonth(newCardData.getMonth());
			existingCard.setYear(newCardData.getYear());
			existingCard.setCvc(newCardData.getCvc());
			
			return existingCard;
		}

}