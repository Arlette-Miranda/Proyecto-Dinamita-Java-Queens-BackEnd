package com.yoatzin.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yoatzin.app.dto.CardsDto;
import com.yoatzin.app.model.Cards;
import com.yoatzin.app.service.CardsDtoService;
import com.yoatzin.app.service.UserDtoService;

@RestController
@RequestMapping("api/v2/users")
@CrossOrigin(origins = "*")
public class CardsDtoController {

	CardsDtoService cardsDtoService;
	UserDtoService userDtoService;

	public CardsDtoController(CardsDtoService cardsDtoService, UserDtoService userDtoService) {
		this.cardsDtoService = cardsDtoService;
	}

	@PostMapping
	ResponseEntity<CardsDto> createCards(@RequestBody CardsDto cards) {
		CardsDto newCard = cardsDtoService.createCards(cards);
		return ResponseEntity.status(201).body(newCard);
	}

	@GetMapping("{id}")
	ResponseEntity<CardsDto> getUserById(@PathVariable("id") Long id) {
		CardsDto existingCards = cardsDtoService.getCardsById(id);
		return ResponseEntity.ok(existingCards);
	}

	@GetMapping
	ResponseEntity<Iterable<CardsDto>> getAllCards(
			@RequestParam(name = "active", required = false, defaultValue = "true") 
			boolean active
			) {
		Iterable<CardsDto> existingCards = CardsDtoService.getAllCards(active);
		return ResponseEntity.ok(existingCards);
	}

	@PutMapping("{id}")
	ResponseEntity<Cards> updateCards(@RequestBody CardsDto newCardsData, @PathVariable("id") Long id) {
		Cards updatedCards = CardsDtoService.updateCards(newCardsData, id);
		return ResponseEntity.ok(updatedCards);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteCards(@PathVariable("id") Long id) {
		CardsDtoService.deleteCard(id);
		return ResponseEntity.status(204).body("Cards id " + id + " successfully deleted");
	}

}