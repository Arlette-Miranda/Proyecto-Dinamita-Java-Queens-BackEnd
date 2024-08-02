package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Addresses;

@Service
public interface AddressesService {
	public Addresses createAddresses(Addresses addresses);
}