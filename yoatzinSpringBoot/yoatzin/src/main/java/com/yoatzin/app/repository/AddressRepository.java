package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Address;


public interface AddressRepository extends CrudRepository<Address, Long> {
	Optional<Address> findByState(String state);
	Optional<Address> findByCity(String city);
}
