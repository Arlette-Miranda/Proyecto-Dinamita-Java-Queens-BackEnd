package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Privileges;
import com.yoatzin.app.repository.PrivilegesRepository;
import com.yoatzin.app.service.PrivilegesService;
import com.yoatzin.app.util.privilegesUpdater;

@Service
public class PrivilegesServiceImpl implements PrivilegesService {
    
    //@Autowired
    PrivilegesRepository privilegesRepository;
    
    public PrivilegesServiceImpl(PrivilegesRepository privilegesRepository) {
        this.privilegesRepository = privilegesRepository;
    }
    
    @Override
    public Privileges createPrivileges(Privileges privileges) { // implementación 
    	Long id_privilege = privileges.getPrivilege();
    	if(privilegesRepository.existsById(id_privilege) ) {
    		throw new IllegalStateException("The id_privilege " + privileges + "is already registered.");
    }
    	privileges.setId_Privilege(null);
		privileges.setActive(true);
		Privileges newPrivileges = savePrivileges(privileges);
		return newPrivileges;
    }

	private Privileges savePrivileges(Privileges privileges) {
		return privilegesRepository.save(privileges);
	}

	@Override
	public Privileges getPrivilegesById_privilege(Long id_privilege) {
		Optional<Privileges> optionalPrivileges = privilegesRepository.findById(id_privilege);
		if (optionalPrivileges.isEmpty() ) {
			throw new IllegalStateException("Privileges does not exist with id " + id_privilege);
		}
		return optionalPrivileges.get();
	}

	@Override
	public Privileges getPrivilegesByDescription(Long description) {
		Optional<Privileges> optionalPrivileges = privilegesRepository.findById(description);
		if (optionalPrivileges.isEmpty() ) {
			throw new IllegalStateException("Privileges does not exist with id " + description);
		}
		return optionalPrivileges.get();
	}

	@Override
	public Iterable<Privileges> getAllActivePrivileges() {
		return privilegesRepository.findAllByActiveTrue();
	}

	@Override
	public Iterable<Privileges> getAllInactivePrivileges() {
		return privilegesRepository.findAllByActiveFalse();
	}

	@Override
	public Iterable<Privileges> getAllPrivileges(boolean isActive) {
		if(isActive) {
			return getAllActivePrivileges();
		}
		return getAllInactivePrivileges();
	}

	
	@Override
	public Privileges updatePrivileges(Privileges newPrivilegesData, Long id_privileges) {
		Privileges existingPrivileges = getPrivilegesById_privilege(id_privileges);
		return privilegesUpdater.updatePrivileges(existingPrivileges, newPrivilegesData);
	}

	@Override
	public void deletePrivileges(Long id_privileges) {
		Privileges existingPrivileges = getPrivilegesById_privilege(id_privileges);
		existingPrivileges.setActive(false);
		savePrivileges(existingPrivileges);
		
	}
    
}
