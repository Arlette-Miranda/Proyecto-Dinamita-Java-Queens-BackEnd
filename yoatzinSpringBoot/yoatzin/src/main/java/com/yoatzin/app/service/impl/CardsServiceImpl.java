package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Cards;
import com.yoatzin.app.repository.CardsRepository;
import com.yoatzin.app.service.CardsService;

@Service
public class CardsServiceImpl implements CardsService {
    
    //@Autowired
    CardsRepository cardsRepository;
    
    public CardsServiceImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }
    
    @Override
    public Cards createCards(Cards cards) {
        Cards newCards = cardsRepository.save(cards);
        return newCards;
    }
}
