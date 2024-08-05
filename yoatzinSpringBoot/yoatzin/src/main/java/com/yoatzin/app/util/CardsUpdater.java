package com.yoatzin.app.util;

import com.yoatzin.app.model.Cards;

public final class CardsUpdater {
	
	private CardsUpdater(){}
	
		public static Cards updateCards(Cards existingCards, Cards newCardsData) {
			if (existingCards == null || newCardsData == null) {
				throw new IllegalArgumentException("Cards data cannot be null");
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