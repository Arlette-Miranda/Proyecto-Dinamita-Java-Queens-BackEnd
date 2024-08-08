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
    	privilege.setId_privilege(null);
		privilege.setActive(true);
		Privilege newPrivilege = savePrivilege(privilege);
		return newPrivilege;
    }

	private Privilege savePrivilege(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}

	@Override
	public Privilege getPrivilegesById_privileges(Long id_privileges) {
		Optional<Privilege> optionalPrivilege = privilegeRepository.findById(id_privileges);
		if (optionalPrivilege.isEmpty() ) {
			throw new IllegalStateException("Privilege does not exist with id " + id_privileges);
		}
		return optionalPrivilege.get();
	}

	@Override
	public Privilege getPrivilegesByDescription(Long description) {
		Optional<Privilege> optionalPrivilege = privilegeRepository.findById(description);
		if (optionalPrivilege.isEmpty() ) {
			throw new IllegalStateException("Privilege does not exist with id " + description);
		}
		return optionalPrivilege.get();
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
	public Privilege updatePrivileges(Privilege newPrivilegeData, Long id_privileges) {
		Privilege existingPrivilege = getPrivilegeById_privilege(id_privileges);
		return PrivilegeUpdater.updatePrivileges(existingPrivilege, newPrivilegeData);
	}

	@Override
	public void deletePrivileges(Long id_privileges) {
		Privilege existingPrivileges = getPrivilegesById_privilege(id_privileges);
		existingPrivileges.setActive(false);
		createPrivileges(existingPrivileges);
		
	}

	@Override
	public Privilege getPrivilegesById_privilege(Long id_privilege) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Privilege updatePrivilege(Privilege newPrivilegeData, Long id_privilege) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Privilege getPrivilegeById_privilege(Long id_privilege) {
		// TODO Auto-generated method stub
		return null;
	}

    
}
