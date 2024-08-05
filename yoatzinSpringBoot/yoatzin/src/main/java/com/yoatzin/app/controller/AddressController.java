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

import com.yoatzin.app.model.Address;
import com.yoatzin.app.service.AddressService;

@RestController
@RequestMapping("api/v1/addresses")
@CrossOrigin(origins = "*")
public class AddressController{
	
	AddressService addressService;
	
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	// Método para crear una nueva dirección
	@PostMapping
	public ResponseEntity<Address> createAddresses(@RequestBody Address address){
		Address newAddresses = addressService.createAddresses(address);
		return ResponseEntity.status(201).body(newAddresses);
	}
	
	// Método para obtener una dirección por ID
	@GetMapping("{id}") // api/v1/addresses/10
	public ResponseEntity<Address> getAddressesById(@PathVariable("id")Long id){
		Address existingAddresses = addressService.getAddressesById(id);
		return ResponseEntity.ok(existingAddresses);
	}
	
	// Método para actualizar una dirección
    @PutMapping("{id}")
    public ResponseEntity<Address> updateAddresses(@RequestBody Address newAddressesData, @PathVariable("id") Long id) {
    	Address updatedAddresses = addressService.updateAddresses(newAddressesData, id);
        return ResponseEntity.ok(updatedAddresses);
    }
    
    // Método para eliminar una dirección
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddresses(@PathVariable("id") Long id) {
    	addressService.deleteAddresses(id);
        return ResponseEntity.status(204).body("Address id " + id + " successfully deleted");
    }
    
}