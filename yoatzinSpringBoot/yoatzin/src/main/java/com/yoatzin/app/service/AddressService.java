package com.yoatzin.app.service;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Address;

@Service
public interface AddressService {
	
	Address createAddresses(Address address);
	Address getAddressesById(Long id);
	Address getAddressesByState(String state);
	Address getAddressesByCity(String city);
	Address updateAddresses (Address address,Long id);
	void deleteAddresses(Long id);
	
}