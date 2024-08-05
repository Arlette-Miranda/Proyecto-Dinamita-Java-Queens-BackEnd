package com.yoatzin.app.util;

import com.yoatzin.app.model.Addresses;

public class AddressesUpdater{
	
	private AddressesUpdater() {}
	
	public static Addresses updateAddresses(Addresses existingAddress, Addresses newAddressData) {
		if (existingAddress == null || newAddressData == null) {
            throw new IllegalArgumentException("Address data cannot be null");
	}
	
		existingAddress.setState(newAddressData.getState());
		existingAddress.setCity(newAddressData.getCity());
		existingAddress.setColony(newAddressData.getColony());
		existingAddress.setStreet(newAddressData.getStreet());
		existingAddress.setZipcode(newAddressData.getZipcode());
		existingAddress.setReference(newAddressData.getReference());
		
		return existingAddress;
	}
}
	