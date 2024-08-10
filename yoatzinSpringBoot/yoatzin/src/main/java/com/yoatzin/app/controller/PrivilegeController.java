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
	public ResponseEntity<Privilege> createPrivilege(@RequestBody Privilege privilege) {
		Privilege newPrivilege = privilegeService.createPrivileges(privilege);
		return ResponseEntity.status(201).body(newPrivilege);
	}
	
	@GetMapping("{id}") // api/v1/privileges/10
	public ResponseEntity<Privilege> getUserById(@PathVariable("id") Long id) {
		Privilege existingPrivilege = privilegeService.getPrivilegesById_privilege(id);
		return ResponseEntity.ok(existingPrivilege);
	}
	
	
	
	@PutMapping("{id}")
	public ResponseEntity<Privilege> updatePrivileges(@RequestBody Privilege newPrivilegesData, @PathVariable("id") Long id) {
		Privilege updatedPrivileges = privilegeService.updatePrivileges(newPrivilegesData, id);
		return ResponseEntity.ok(updatedPrivileges);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePrivileges(@PathVariable("id") Long id) {
		privilegeService.deletePrivileges(id);
		return ResponseEntity.status(204).body("Privilege id " + id + " successfully deleted");
	}
	
	
	
}
