package com.yoatzin.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.model.User;
import com.yoatzin.app.service.UserService;


@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userService.createUser(user);
		return ResponseEntity.status(201).body(newUser);
	}
	
	@GetMapping("{id}") // api/v1/users/10
	ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User existingUser = userService.getUserById(id);
		return ResponseEntity.ok(existingUser);
	}
	
	@GetMapping // api/v1/users?active=false
	ResponseEntity<Iterable<User>> getAllUsers(
			@RequestParam(name = "active", required = false, defaultValue = "true") 
			boolean active
			) {
		Iterable<User> existingUsers = userService.getAllUser(active);
		return ResponseEntity.ok(existingUsers);
	}
	
	@PutMapping("{id}")
	ResponseEntity<User> updateUser(@RequestBody User newUserData, @PathVariable("id") Long id) {
		User updatedUser = userService.updateUser(newUserData, id);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return ResponseEntity.status(204).body("User id " + id + " successfully deleted");
	}
	
	
	
}
