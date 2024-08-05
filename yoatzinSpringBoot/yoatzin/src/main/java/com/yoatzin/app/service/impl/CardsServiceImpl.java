package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Cards;
import com.yoatzin.app.repository.CardsRepository;
import com.yoatzin.app.service.CardsService;
import com.yoatzin.app.util.CardsUpdater;

@Service
public class CardsServiceImpl implements CardsService {
    
    //@Autowired
    CardsRepository cardsRepository;
    
    public CardsServiceImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }
    
    @Override
    public Cards createCards(Cards cards) { //implementación 
    	Long id_card = cards.getFk_id_user();
    	if(cardsRepository.existsById(id_card) ) {
    		throw new IllegalStateException("The id_cards " + cards + "is already registered.");
    	}
    	cards.setId_card(null);
		cards.setActive(true);
		Cards newCards = saveCards(cards);
		return newCards;
    }

	private Cards saveCards(Cards cards) {
		return cardsRepository.save(cards);
	}

	@Override
	public Cards getCardsById_card(Long id_card) {
		Optional<Cards> optionalCards = cardsRepository.findById(id_card);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Cards does not exist with id " + id_card);
		}
		return optionalCards.get();
	}

	@Override
	public Cards getCardsByNumber(Long number) {
		Optional<Cards> optionalCards = cardsRepository.findById(number);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Cards does not exist with number" + number);
		}
		return optionalCards.get();
	}

	@Override
	public Cards getCardsByOwner_card(Long owner_card) {
		Optional<Cards> optionalCards = cardsRepository.findById(owner_card);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Cards does not exist with owner_card" + owner_card);
		}
		return optionalCards.get();
	}

	@Override
	public Cards getCardsByMonth(Long month) {
		Optional<Cards> optionalCards = cardsRepository.findById(month);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Cards does not exist with month" + month);
		}
		return optionalCards.get();
	}

	@Override
	public Cards getCardsByYear(Long year) {
		Optional<Cards> optionalCards = cardsRepository.findById(year);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Cards does not exist with year" + year);
		}
		return optionalCards.get();
	}

	@Override
	public Cards getCardsByCvc(Long cvc) {
		Optional<Cards> optionalCards = cardsRepository.findById(cvc);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Cards does not exist with cvc" + cvc);
		}
		return optionalCards.get();
	}

	@Override
	public Iterable<Cards> getAllActiveCards() {
		return cardsRepository.findAllByActiveTrue();
	}

	@Override
	public Iterable<Cards> getAllInactiveCards() {
		return cardsRepository.findAllByActiveFalse();
	}

	@Override
	public Iterable<Cards> getAllCards(boolean isActive) {
		if(isActive) {
			return getAllActiveCards();
		}
		return getAllInactiveCards();
	}

	@Override
	public Cards updateCards(Cards newCardsData, Long id_card) {
		Cards existingCards = getCardsById_card(id_card);
		return CardsUpdater.updateCards(existingCards, newCardsData);
	}

	@Override
	public void deleteCards(Long id_card) {
		Cards existingCards = getCardsById_card(id_card);
		existingCards.setActive(false);
		saveCards(existingCards);	
		
	}
}
