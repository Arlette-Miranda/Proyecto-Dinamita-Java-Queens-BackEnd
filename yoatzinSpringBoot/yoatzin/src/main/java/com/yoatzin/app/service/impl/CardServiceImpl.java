package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Card;
import com.yoatzin.app.model.User;
import com.yoatzin.app.repository.CardRepository;
import com.yoatzin.app.service.CardService;
import com.yoatzin.app.util.CardUpdater;

@Service
public class CardServiceImpl implements CardService {
    
    //@Autowired
    CardRepository cardRepository;
    
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    
    @Override
    public Card createCards(Card card) { //implementación 
    	User id_card = card.getUser();
    	if(cardRepository.existsById(id_card) ) {
    		throw new IllegalStateException("The id_cards " + card + "is already registered.");
    	}
    	card.setId_card(null);
		card.setActive(true);
		Card newCards = saveCards(card);
		return newCards;
    }

	private Card saveCards(Card card) {
		return cardRepository.save(card);
	}

	@Override
	public Card getCardsById_card(Long id_card) {
		Optional<Card> optionalCards = cardRepository.findById(id_card);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Card does not exist with id " + id_card);
		}
		return optionalCards.get();
	}

	@Override
	public Card getCardsByNumber(Long number) {
		Optional<Card> optionalCards = cardRepository.findById(number);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Card does not exist with number" + number);
		}
		return optionalCards.get();
	}

	@Override
	public Card getCardsByOwner_card(Long owner_card) {
		Optional<Card> optionalCards = cardRepository.findById(owner_card);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Card does not exist with owner_card" + owner_card);
		}
		return optionalCards.get();
	}

	@Override
	public Card getCardsByMonth(Long month) {
		Optional<Card> optionalCards = cardRepository.findById(month);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Card does not exist with month" + month);
		}
		return optionalCards.get();
	}

	@Override
	public Card getCardsByYear(Long year) {
		Optional<Card> optionalCards = cardRepository.findById(year);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Card does not exist with year" + year);
		}
		return optionalCards.get();
	}

	@Override
	public Card getCardsByCvc(Long cvc) {
		Optional<Card> optionalCards = cardRepository.findById(cvc);
		if (optionalCards.isEmpty() ) {
			throw new IllegalStateException("Card does not exist with cvc" + cvc);
		}
		return optionalCards.get();
	}

	@Override
	public Iterable<Card> getAllActiveCards() {
		return cardRepository.findAllByActiveTrue();
	}

	@Override
	public Iterable<Card> getAllInactiveCards() {
		return cardRepository.findAllByActiveFalse();
	}

	@Override
	public Iterable<Card> getAllCards(boolean isActive) {
		if(isActive) {
			return getAllActiveCards();
		}
		return getAllInactiveCards();
	}

	@Override
	public Card updateCards(Card newCardsData, Long id_card) {
		Card existingCards = getCardsById_card(id_card);
		return CardUpdater.updateCards(existingCards, newCardsData);
	}

	@Override
	public void deleteCards(Long id_card) {
		Card existingCards = getCardsById_card(id_card);
		existingCards.setActive(false);
		saveCards(existingCards);	
		
	}
}
