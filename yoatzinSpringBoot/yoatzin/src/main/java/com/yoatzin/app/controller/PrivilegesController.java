package com.yoatzin.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.model.Privileges;
import com.yoatzin.app.model.User;
import com.yoatzin.app.service.PrivilegesService;
import com.yoatzin.app.service.UserService;


@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "*")
public class PrivilegesController {
	
	PrivilegesService privilegesService;

	public PrivilegesController(PrivilegesService userService) {
		this.privilegesService = privilegesService;
	}
	
	@PostMapping
	ResponseEntity<Privileges> createPrivileges(@RequestBody Privileges privileges) {
		Privileges newPrivilege = privilegesService.createPrivileges(privileges);
		return ResponseEntity.status(201).body(newPrivilege);
	}
	
	@GetMapping("{id}") // api/v1/users/10
	ResponseEntity<Privileges> getUserById(@PathVariable("id") Long id) {
		Privileges existingPrivileges = privilegesService.getPrivilegesById_privilege(id);
		return ResponseEntity.ok(existingPrivileges);
	}
	
	@GetMapping // api/v1/users?active=false
	ResponseEntity<Iterable<Privileges>> getAllPrivileges(
			@RequestParam(name = "active", required = false, defaultValue = "true") 
			boolean active
			) {
		Iterable<Privileges> existingPrivileges = privilegesService.getAllPrivileges(active);
		return ResponseEntity.ok(existingPrivileges);
	}
	
	@PutMapping("{id}")
	ResponseEntity<Privileges> updatePrivileges(@RequestBody Privileges newPrivilegesData, @PathVariable("id") Long id) {
		Privileges updatedPrivileges = privilegesService.updatePrivileges(newPrivilegesData, id);
		return ResponseEntity.ok(updatedPrivileges);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deletePrivileges(@PathVariable("id") Long id) {
		privilegesService.deletePrivileges(id);
		return ResponseEntity.status(204).body("Privileges id " + id + " successfully deleted");
	}
	
	
	
}
