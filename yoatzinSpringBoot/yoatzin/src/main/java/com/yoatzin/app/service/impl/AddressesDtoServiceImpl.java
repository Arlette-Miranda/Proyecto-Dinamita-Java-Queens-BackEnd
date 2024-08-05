package com.yoatzin.app.service.impl;

import com.yoatzin.app.dto.AddressesDto;
import com.yoatzin.app.model.Addresses;
import com.yoatzin.app.service.AddressesDtoService;
import com.yoatzin.app.service.AddressesService;

public class AddressesDtoServiceImpl implements AddressesDtoService{
	
	AddressesService addressesService;
	
	public AddressesDtoServiceImpl(AddressesService addressesService) {
		this.addressesService = addressesService;
	}
	@Override
	public AddressesDto createAddresses(Addresses addresses) {
		Addresses newAddresses = addressesService.createAddresses(addresses);
		AddressesDto newAddressesDto = new AddressesDto();
		newAddressesDto.setSerialNumber(newAddresses.getId_address());
		newAddressesDto.setState(newAddresses.getState());
		newAddressesDto.setCity(newAddresses.getCity());
		newAddressesDto.setColony(newAddresses.getColony());
		newAddressesDto.setStreet(newAddresses.getStreet());
		newAddressesDto.setZipcode(newAddresses.getZipcode());
		newAddressesDto.setReference(newAddresses.getReference());
		
		return newAddressesDto;
	}
	
	@Override
	public AddressesDto getAddressesById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AddressesDto getAddressesByState(String state) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AddressesDto getAddressesByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AddressesDto updateAddresses(Addresses addresses, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAddresses(Long id) {
		// TODO Auto-generated method stub
		
	}
}