package com.yoatzin.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.model.Card;
import com.yoatzin.app.model.User;
import com.yoatzin.app.service.CardService;
import com.yoatzin.app.service.UserService;


@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "*")
public class CardController {
	
	CardService cardService;

	public CardController(CardService cardService) {
		this.cardService = cardService;
	}
	
	@PostMapping
	ResponseEntity<Card> createCard(@RequestBody Card card) {
		Card newCard = cardService.createCards(card);
		return ResponseEntity.status(201).body(newCard);
	}
	
	@GetMapping("{id}") // api/v1/users/10
	ResponseEntity<Card> getCardById(@PathVariable("id") Long id) {
		Card existingUser = cardService.getCardsById_card(id);
		return ResponseEntity.ok(existingUser);
	}
	
	@GetMapping // api/v1/users?active=false
	ResponseEntity<Iterable<Card>> getAllCards(
			@RequestParam(name = "active", required = false, defaultValue = "true") 
			boolean active
			) {
		Iterable<Card> existingCards = cardService.getAllCards(active);
		return ResponseEntity.ok(existingCards);
	}
	
	@PutMapping("{id}")
	ResponseEntity<Card> updateCard(@RequestBody Card newCardsData, @PathVariable("id") Long id) {
		Card updatedCard = cardService.updateCards(newCardsData, id);
		return ResponseEntity.ok(updatedCard);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteCards(@PathVariable("id") Long id) {
		cardService.deleteCards(id);
		return ResponseEntity.status(204).body("Card id " + id + " successfully deleted");
	}
	
	
	
}
