package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Cards;

@Service
public interface CardsService {
	
	Cards createCards(Cards cards);
    Cards getCardsById_card(Long id_card);
    Cards getCardsByNumber(Long number);
    Cards getCardsByOwner_card(Long owner_card);
    Cards getCardsByMonth(Long month);
    Cards getCardsByYear(Long year);
    Cards getCardsByCvc(Long cvc);
    Iterable<Cards> getAllActiveCards();
	Iterable<Cards> getAllInactiveCards();
	Iterable<Cards> getAllCards(boolean isActive);
	Cards updateCards(Cards cards, Long id_card);
	void deleteCards(Long id_card);
	
}
