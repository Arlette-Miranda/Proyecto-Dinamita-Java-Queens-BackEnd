package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Addresses;
import com.yoatzin.app.model.Products;

public interface AddressesRepository extends CrudRepository<Addresses, Long> {
	Optional<Products> findByState(String state);
	Optional<Products> findByCity(String city);
}
