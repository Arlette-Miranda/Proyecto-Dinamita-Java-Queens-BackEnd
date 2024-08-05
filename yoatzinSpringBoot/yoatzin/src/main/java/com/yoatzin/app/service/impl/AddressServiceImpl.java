package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Address;
import com.yoatzin.app.repository.AddressesRepository;
import com.yoatzin.app.service.AddressService;
import com.yoatzin.app.util.AddressUpdater;

@Service

public class AddressServiceImpl implements AddressService {
    
    //@Autowired
    AddressesRepository addressesRepository;
    
    public AddressServiceImpl(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

	@Override
	public Address createAddresses(Address address) {
		address.setId_address(null);
		Address newAddresses = saveAddresses(address);
        return newAddresses;
	}

	private Address saveAddresses(Address address) {
		return addressesRepository.save(address);
	}

	@Override
	public Address getAddressesById(Long id) {
		Optional<Address> optionalAddress = addressesRepository.findById(id);
        if (optionalAddress.isEmpty()) {
            throw new IllegalStateException("Address does not exist with id " + id);
        }
        return optionalAddress.get();
	}

	@Override
	public Address getAddressesByState(String state) {
		Optional<Address> optionalAddress = addressesRepository.findByState(state);
        if (optionalAddress.isEmpty()) {
            throw new IllegalStateException("Address does not exist with state " + state);
        }
        return optionalAddress.get();
	}

	@Override
	public Address getAddressesByCity(String city) {
		Optional<Address> optionalAddress = addressesRepository.findByCity(city);
        if (optionalAddress.isEmpty()) {
            throw new IllegalStateException("Address does not exist with city " + city);
        }
        return optionalAddress.get();
	}

	@Override
	public Address updateAddresses(Address newAddressesData, Long id) {
		Address existingAddress = getAddressesById(id);         
		return AddressUpdater.updateAddresses(existingAddress, newAddressesData);
	}

	@Override
	public void deleteAddresses(Long id) {
		Address existingAddress = getAddressesById(id); 
		saveAddresses(existingAddress);
	}

}
