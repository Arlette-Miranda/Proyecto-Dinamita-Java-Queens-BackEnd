package com.yoatzin.app.service.impl;


import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Addresses;
import com.yoatzin.app.repository.AddressesRepository;
import com.yoatzin.app.service.AddressesService;

@Service

public class AddressesServiceImpl implements AddressesService {
    
    //@Autowired
    AddressesRepository addressesRepository;
    
    public AddressesServiceImpl(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }
    
    @Override
    public Addresses createAddresses(Addresses addresses) {
        Addresses newAddresses = addressesRepository.save(addresses);
        return newAddresses;
    }

}
