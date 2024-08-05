package com.yoatzin.app.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Cards;

public interface CardsRepository extends CrudRepository<Cards, Long> {

	Optional<Cards> findById_Cards(Long id_cards);
	Iterable<Cards> findAllByActiveTrue();
	Iterable<Cards> findAllByActiveFalse();
	boolean existsById_Cards(Long id_cards);
	
}

