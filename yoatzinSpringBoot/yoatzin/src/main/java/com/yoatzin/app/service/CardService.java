package com.yoatzin.app.service;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Card;

@Service
public interface CardService {
	
	Card createCards(Card card);
    Card getCardsById_card(Long id_card);
    Card getCardsByNumber(Long number);
    Card getCardsByOwner_card(Long owner_card);
    Card getCardsByMonth(Long month);
    Card getCardsByYear(Long year);
    Card getCardsByCvc(Long cvc);
    Iterable<Card> getAllActiveCards();
	Iterable<Card> getAllInactiveCards();
	Iterable<Card> getAllCards(boolean isActive);
	Card updateCards(Card card, Long id_card);
	void deleteCards(Long id_card);
	
}
