package com.yoatzin.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Addresses;

public interface AddressesRepository extends CrudRepository<Addresses, Long> {

}
