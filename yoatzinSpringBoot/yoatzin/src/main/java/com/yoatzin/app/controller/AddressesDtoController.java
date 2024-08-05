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
import org.springframework.web.bind.annotation.RestController;

import com.yoatzin.app.dto.AddressesDto;
import com.yoatzin.app.model.Addresses;
import com.yoatzin.app.service.AddressesDtoService;

@RestController
@RequestMapping("api/v2/addresses")
@CrossOrigin(origins = "*")
public class AddressesDtoController{
	
	AddressesDtoService addressesDtoService;
	
	public AddressesDtoController(AddressesDtoService addressesDtoService) {
		this.addressesDtoService = addressesDtoService;
	}
	
	// Método para crear una nueva dirección
	@PostMapping
	public ResponseEntity<AddressesDto> createAddresses(@RequestBody Addresses addresses){
		AddressesDto newAddresses = addressesDtoService.createAddresses(addresses);
		return ResponseEntity.status(201).body(newAddresses);
	}
	
	// Método para obtener una dirección por ID
	@GetMapping("{id}") // api/v1/addresses/10
	public ResponseEntity<AddressesDto> getAddressesById(@PathVariable("id")Long id){
		AddressesDto existingAddresses = addressesDtoService.getAddressesById(id);
		return ResponseEntity.ok(existingAddresses);
	}
	
	// Método para actualizar una dirección
    @PutMapping("{id}")
    public ResponseEntity<AddressesDto> updateAddresses(@RequestBody Addresses newAddressesData, @PathVariable("id") Long id) {
    	AddressesDto updatedAddresses = addressesDtoService.updateAddresses(newAddressesData, id);
        return ResponseEntity.ok(updatedAddresses);
    }
    
    // Método para eliminar una dirección
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddresses(@PathVariable("id") Long id) {
    	addressesDtoService.deleteAddresses(id);
        return ResponseEntity.status(204).body("Address id " + id + " successfully deleted");
    }
    
}