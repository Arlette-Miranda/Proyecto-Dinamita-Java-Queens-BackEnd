package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Addresses;
import com.yoatzin.app.repository.AddressesRepository;
import com.yoatzin.app.service.AddressesService;
import com.yoatzin.app.util.AddressesUpdater;

@Service

public class AddressesServiceImpl implements AddressesService {
    
    //@Autowired
    AddressesRepository addressesRepository;
    
    public AddressesServiceImpl(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

	@Override
	public Addresses createAddresses(Addresses addresses) {
		addresses.setId_address(null);
		Addresses newAddresses = saveAddresses(addresses);
        return newAddresses;
	}

	private Addresses saveAddresses(Addresses addresses) {
		return addressesRepository.save(addresses);
	}

	@Override
	public Addresses getAddressesById(Long id) {
		Optional<Addresses> optionalAddress = addressesRepository.findById(id);
        if (optionalAddress.isEmpty()) {
            throw new IllegalStateException("Address does not exist with id " + id);
        }
        return optionalAddress.get();
	}

	@Override
	public Addresses getAddressesByState(String state) {
		Optional<Addresses> optionalAddress = addressesRepository.findByState(state);
        if (optionalAddress.isEmpty()) {
            throw new IllegalStateException("Address does not exist with state " + state);
        }
        return optionalAddress.get();
	}

	@Override
	public Addresses getAddressesByCity(String city) {
		Optional<Addresses> optionalAddress = addressesRepository.findByCity(city);
        if (optionalAddress.isEmpty()) {
            throw new IllegalStateException("Address does not exist with city " + city);
        }
        return optionalAddress.get();
	}

	@Override
	public Addresses updateAddresses(Addresses newAddressesData, Long id) {
		Addresses existingAddress = getAddressesById(id);         
		return AddressesUpdater.updateAddresses(existingAddress, newAddressesData);
	}

	@Override
	public void deleteAddresses(Long id) {
		Addresses existingAddress = getAddressesById(id); 
		saveAddresses(existingAddress);
	}

}
