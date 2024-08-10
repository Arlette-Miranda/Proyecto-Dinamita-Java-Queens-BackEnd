package com.yoatzin.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.model.Card;
import com.yoatzin.app.service.CardService;


@RestController
@RequestMapping("api/v1/cards")
@CrossOrigin(origins = "*")
public class CardController {
	
	CardService cardService;

	
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}
	
	@PostMapping
	public ResponseEntity<Card> createCards(@RequestBody Card card) {
		Card newCards = cardService.createCards(card);
		return ResponseEntity.status(201).body(newCards);
	}
	
	@GetMapping("{id}") // api/v1/users/10
	public ResponseEntity<Card> getCardsById(@PathVariable("id") Long id) {
		Card existingCards = cardService.getCardsById_card(id);
		return ResponseEntity.ok(existingCards);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Card> updateCards(@RequestBody Card newCardsData, @PathVariable("id") Long id) {
		Card updatedCards = cardService.updateCards(newCardsData, id);
		return ResponseEntity.ok(updatedCards);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCards(@PathVariable("id") Long id) {
		cardService.deleteCards(id);
		return ResponseEntity.status(204).body("Card id " + id + " successfully deleted");
	}
	
	
	
}
