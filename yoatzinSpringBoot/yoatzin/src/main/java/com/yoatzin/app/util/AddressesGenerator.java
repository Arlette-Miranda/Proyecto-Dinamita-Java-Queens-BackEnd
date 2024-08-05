package com.yoatzin.app.util;

import java.util.ArrayList;
import java.util.List;

import com.yoatzin.app.model.Addresses;

public class AddressesGenerator{
	
	private AddressesGenerator() {}
	
	public static List<Addresses> generateRandomAddresses (int quantity){
		List<Addresses> addresses = new ArrayList<>();
		
		for (int i = 0; i < quantity; i++) {
			addresses.add(generateRandomAddress());
        }

        return addresses;
	}

	private static Addresses generateRandomAddress() {
		return null;
	}
}