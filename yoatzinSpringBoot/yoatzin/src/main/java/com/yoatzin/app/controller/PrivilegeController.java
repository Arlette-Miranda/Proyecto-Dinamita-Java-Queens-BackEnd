package com.yoatzin.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yoatzin.app.model.Privilege;
import com.yoatzin.app.service.PrivilegeService;


@RestController
@RequestMapping("api/v1/privileges")
@CrossOrigin(origins = "*")
public class PrivilegeController {
	
	PrivilegeService privilegeService;

	public PrivilegeController(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}
	
	@PostMapping
	ResponseEntity<Privilege> createPrivilege(@RequestBody Privilege privilege) {
		Privilege newPrivilege = privilegeService.createPrivileges(privilege);
		return ResponseEntity.status(201).body(newPrivilege);
	}
	
	@GetMapping("{id}") // api/v1/users/10
	ResponseEntity<Privilege> getUserById(@PathVariable("id") Long id) {
		Privilege existingPrivilege = privilegeService.getPrivilegesById_privilege(id);
		return ResponseEntity.ok(existingPrivilege);
	}
	
	@GetMapping // api/v1/users?active=false
	ResponseEntity<Iterable<Privilege>> getAllPrivileges(
			@RequestParam(name = "active", required = false, defaultValue = "true") 
			boolean active
			) {
		Iterable<Privilege> existingPrivileges = privilegeService.getAllPrivileges(active);
		return ResponseEntity.ok(existingPrivileges);
	}
	
	@PutMapping("{id}")
	ResponseEntity<Privilege> updatePrivileges(@RequestBody Privilege newPrivilegeData, @PathVariable("id") Long id) {
		Privilege updatedPrivilege = privilegeService.updatePrivileges(newPrivilegeData, id);
		return ResponseEntity.ok(updatedPrivilege);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deletePrivilege(@PathVariable("id") Long id) {
		privilegeService.deletePrivileges(id);
		return ResponseEntity.status(204).body("Privilege id " + id + " successfully deleted");
	}
	
	
	
}
