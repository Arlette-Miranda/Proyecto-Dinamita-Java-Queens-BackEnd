package com.yoatzin.app.util;

import com.yoatzin.app.model.Card;

public final class CardUpdater {
	
	private CardUpdater(){}
	
		public static Card updateCards(Card existingCards, Card newCardsData) {
			if (existingCards == null || newCardsData == null) {
				throw new IllegalArgumentException("Card data cannot be null");
			}
			
			existingCards.setId_card(newCardsData.getId_card());
			existingCards.setNumber(newCardsData.getNumber());
			existingCards.setOwner_card(newCardsData.getOwner_card());
			existingCards.setMonth(newCardsData.getMonth());
			existingCards.setYear(newCardsData.getYear());
			existingCards.setCvc(newCardsData.getCvc());
			
			return existingCards;
		}

}