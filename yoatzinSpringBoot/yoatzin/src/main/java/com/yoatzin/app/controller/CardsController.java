package com.yoatzin.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.model.Cards;
import com.yoatzin.app.model.User;
import com.yoatzin.app.service.CardsService;
import com.yoatzin.app.service.UserService;


@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "*")
public class CardsController {
	
	CardsService cardService;

	public CardsController(CardsService cardService) {
		this.cardService = cardService;
	}
	
	@PostMapping
	ResponseEntity<Cards> createCard(@RequestBody Cards card) {
		Cards newCard = cardService.createCards(card);
		return ResponseEntity.status(201).body(newCard);
	}
	
	@GetMapping("{id}") // api/v1/users/10
	ResponseEntity<Cards> getCardById(@PathVariable("id") Long id) {
		Cards existingUser = cardService.getCardsById_card(id);
		return ResponseEntity.ok(existingUser);
	}
	
	@GetMapping // api/v1/users?active=false
	ResponseEntity<Iterable<Cards>> getAllCards(
			@RequestParam(name = "active", required = false, defaultValue = "true") 
			boolean active
			) {
		Iterable<Cards> existingCards = cardService.getAllCards(active);
		return ResponseEntity.ok(existingCards);
	}
	
	@PutMapping("{id}")
	ResponseEntity<Cards> updateCard(@RequestBody Cards newCardsData, @PathVariable("id") Long id) {
		Cards updatedCard = cardService.updateCards(newCardsData, id);
		return ResponseEntity.ok(updatedCard);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteCards(@PathVariable("id") Long id) {
		cardService.deleteCards(id);
		return ResponseEntity.status(204).body("Cards id " + id + " successfully deleted");
	}
	
	
	
}
