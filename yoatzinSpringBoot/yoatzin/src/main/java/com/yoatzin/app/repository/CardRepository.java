package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Card;

public interface CardRepository extends CrudRepository<Card, Long> {
	Optional<Card> findByOwnerCard(String ownerCard);
	
	
	
}

