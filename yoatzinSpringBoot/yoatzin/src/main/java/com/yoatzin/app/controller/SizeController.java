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

import com.yoatzin.app.model.Size;
import com.yoatzin.app.service.SizeService;

@RestController
@RequestMapping("api/v1/sizes")
@CrossOrigin(origins = "*")
public class SizeController{
	
	SizeService sizeService;
	
	public SizeController(SizeService sizeService) {
		this.sizeService = sizeService;
	}
	
	// Método para crear una nueva talla
		@PostMapping
		public ResponseEntity<Size> createSizes(@RequestBody Size size){
			Size newSizes = sizeService.createSizes(size);
			return ResponseEntity.status(201).body(newSizes);
		}
		
		// Método para obtener una talla por ID
		@GetMapping("{id}") // api/v1/addresses/10
		public ResponseEntity<Size> getSizesById(@PathVariable("id")Long id){
			Size existingSizes = sizeService.getSizesById(id);
			return ResponseEntity.ok(existingSizes);
		}
		
		// Método para actualizar una talla
	    @PutMapping("{id}")
	    public ResponseEntity<Size> updateSizes(@RequestBody Size newSizesData, @PathVariable("id") Long id) {
	    	Size updatedSizes = sizeService.updateSizes(newSizesData, id);
	        return ResponseEntity.ok(updatedSizes);
	    }
	    
	    // Método para eliminar una talla
	    @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteSizes(@PathVariable("id") Long id) {
	    	sizeService.deleteSizes(id);
	        return ResponseEntity.status(204).body("Size id " + id + " successfully deleted");
	    }
}