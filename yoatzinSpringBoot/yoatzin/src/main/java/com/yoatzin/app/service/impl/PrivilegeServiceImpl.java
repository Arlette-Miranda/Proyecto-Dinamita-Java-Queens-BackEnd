package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Privilege;
import com.yoatzin.app.repository.PrivilegeRepository;
import com.yoatzin.app.service.PrivilegeService;
import com.yoatzin.app.util.PrivilegeUpdater;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    
    //@Autowired
    PrivilegeRepository privilegeRepository;
    
    public PrivilegeServiceImpl(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }
    
    @Override
    public Privilege createPrivileges(Privilege privilege) { // implementación 
    	Long id_privilege = privilege.getPrivilege();
    	if(privilegeRepository.existsById(id_privilege) ) {
    		throw new IllegalStateException("The id_privilege " + privilege + "is already registered.");
    }
    	privilege.setId_Privilege(null);
		privilege.setActive(true);
		Privilege newPrivileges = savePrivileges(privilege);
		return newPrivileges;
    }

	private Privilege savePrivileges(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}

	@Override
	public Privilege getPrivilegesById_privilege(Long id_privilege) {
		Optional<Privilege> optionalPrivileges = privilegeRepository.findById(id_privilege);
		if (optionalPrivileges.isEmpty() ) {
			throw new IllegalStateException("Privilege does not exist with id " + id_privilege);
		}
		return optionalPrivileges.get();
	}

	@Override
	public Privilege getPrivilegesByDescription(Long description) {
		Optional<Privilege> optionalPrivileges = privilegeRepository.findById(description);
		if (optionalPrivileges.isEmpty() ) {
			throw new IllegalStateException("Privilege does not exist with id " + description);
		}
		return optionalPrivileges.get();
	}

	@Override
	public Iterable<Privilege> getAllActivePrivileges() {
		return privilegeRepository.findAllByActiveTrue();
	}

	@Override
	public Iterable<Privilege> getAllInactivePrivileges() {
		return privilegeRepository.findAllByActiveFalse();
	}

	@Override
	public Iterable<Privilege> getAllPrivileges(boolean isActive) {
		if(isActive) {
			return getAllActivePrivileges();
		}
		return getAllInactivePrivileges();
	}

	
	@Override
	public Privilege updatePrivileges(Privilege newPrivilegesData, Long id_privileges) {
		Privilege existingPrivileges = getPrivilegesById_privilege(id_privileges);
		return PrivilegeUpdater.updatePrivileges(existingPrivileges, newPrivilegesData);
	}

	@Override
	public void deletePrivileges(Long id_privileges) {
		Privilege existingPrivileges = getPrivilegesById_privilege(id_privileges);
		existingPrivileges.setActive(false);
		savePrivileges(existingPrivileges);
		
	}
    
}
