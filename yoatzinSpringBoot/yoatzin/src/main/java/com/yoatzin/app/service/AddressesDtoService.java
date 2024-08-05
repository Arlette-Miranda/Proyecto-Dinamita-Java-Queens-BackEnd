package com.yoatzin.app.service;

import com.yoatzin.app.dto.AddressesDto;
import com.yoatzin.app.model.Addresses;

public interface AddressesDtoService {
	
	AddressesDto createAddresses(Addresses addresses);
	AddressesDto getAddressesById(Long id);
	AddressesDto getAddressesByState(String state);
	AddressesDto getAddressesByCity(String city);
	AddressesDto updateAddresses (Addresses addresses,Long id);
	void deleteAddresses(Long id);
}