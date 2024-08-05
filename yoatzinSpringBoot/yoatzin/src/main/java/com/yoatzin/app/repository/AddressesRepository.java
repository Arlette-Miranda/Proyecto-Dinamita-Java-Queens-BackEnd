package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Addresses;


public interface AddressesRepository extends CrudRepository<Addresses, Long> {
	Optional<Addresses> findByState(String state);
	Optional<Addresses> findByCity(String city);
}
