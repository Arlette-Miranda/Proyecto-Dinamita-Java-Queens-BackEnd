package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Addresses;

@Service
public interface AddressesService {
	
	Addresses createAddresses(Addresses addresses);
	Addresses getAddressesById(Long id);
	Addresses getAddressesByState(String state);
	Addresses getAddressesByCity(String city);
	Addresses updateAddresses (Addresses addresses,Long id);
	void deleteAddresses(Long id);
	
}