package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Card;
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
	public Card createCards(Card card) {
		card.setId_card(null);
		Card newCards = saveCards(card);
        return newCards;
	}

	private Card saveCards(Card card) {
		return cardRepository.save(card);
	}

	@Override
	public Card getCardsById_card(Long id_card) {
		Optional<Card> optionalCard = cardRepository.findById(id_card);
        if (optionalCard.isEmpty()) {
            throw new IllegalStateException("Card does not exist with id " + id_card);
        }
        return optionalCard.get();
	}

	@Override
	public Card getCardsByOwnerCard(String ownerCard) {
		Optional<Card> optionalCard = cardRepository.findByOwnerCard(ownerCard);
        if (optionalCard.isEmpty()) {
            throw new IllegalStateException("Card does not exist with owner " + ownerCard);
        }
        return optionalCard.get();
	}


	@Override
	public Card updateCards(Card newCardsData, Long id_card) {
		Card existingCard = getCardsById_card(id_card);         
		return CardUpdater.updateCards(existingCard, newCardsData);
	}

	@Override
	public void deleteCards(Long id_card) {
		Card existingCard = getCardsById_card(id_card); 
		saveCards(existingCard);
		
	}
    
   
	
}
