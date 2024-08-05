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

import com.yoatzin.app.model.Sizes;
import com.yoatzin.app.service.SizesService;

@RestController
@RequestMapping("api/v1/sizes")
@CrossOrigin(origins = "*")
public class SizesController{
	
	SizesService sizesService;
	
	public SizesController(SizesService sizesService) {
		this.sizesService = sizesService;
	}
	
	// Método para crear una nueva talla
		@PostMapping
		public ResponseEntity<Sizes> createSizes(@RequestBody Sizes sizes){
			Sizes newSizes = sizesService.createSizes(sizes);
			return ResponseEntity.status(201).body(newSizes);
		}
		
		// Método para obtener una talla por ID
		@GetMapping("{id}") // api/v1/addresses/10
		public ResponseEntity<Sizes> getSizesById(@PathVariable("id")Long id){
			Sizes existingSizes = sizesService.getSizesById(id);
			return ResponseEntity.ok(existingSizes);
		}
		
		// Método para actualizar una talla
	    @PutMapping("{id}")
	    public ResponseEntity<Sizes> updateSizes(@RequestBody Sizes newSizesData, @PathVariable("id") Long id) {
	    	Sizes updatedSizes = sizesService.updateSizes(newSizesData, id);
	        return ResponseEntity.ok(updatedSizes);
	    }
	    
	    // Método para eliminar una talla
	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteSizes(@PathVariable("id") Long id) {
	    	sizesService.deleteSizes(id);
	        return ResponseEntity.status(204).body("Sizes id " + id + " successfully deleted");
	    }
}