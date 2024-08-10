package com.yoatzin.app.service;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Card;

//@Service
public interface CardService {
	
	Card createCards(Card card);
    Card getCardsById_card(Long id_card);
    Card getCardsByOwnerCard(String ownerCard);
	Card updateCards(Card card, Long id_card);
	void deleteCards(Long id_card);
	
	
}
