package com.yoatzin.app.service;

import com.yoatzin.app.dto.CardsDto;
import com.yoatzin.app.model.Cards;

public interface CardsDtoService {

	 CardsDto createCards(CardsDto cards);
	 CardsDto getCardsById(Long id);
	 CardsDto getCardsByNumber(Long number);
	 CardsDto getCardsByOwner_card(Long owner_card);
	 CardsDto getCardsByMonth(Long month);
	 CardsDto getCardsByYear(Long year);
	 CardsDto getCardsByCvc(Long cvc);
	 Iterable<CardsDto> getAllActiveCards();
     Iterable<CardsDto> getAllInactiveCards();
	 Iterable<CardsDto> getAllCards(boolean isActive);
	 CardsDto updateCardsDto(Cards cards, Long id_card);
	 void deleteCards(Long id_card);
	
}
