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
	public Privilege createPrivileges(Privilege privilege) {
		privilege.setIdPrivilege(null);
		Privilege newPrivileges = savePrivileges(privilege);
        return newPrivileges;
	}

	private Privilege savePrivileges(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}

	@Override
	public Privilege getPrivilegesById_privilege(Long id_privilege) {
		Optional<Privilege> optionalPrivilege = privilegeRepository.findById(id_privilege);
        if (optionalPrivilege.isEmpty()) {
            throw new IllegalStateException("Privilege does not exist with id " + id_privilege);
        }
        return optionalPrivilege.get();
	}



	@Override
	public Privilege getPrivilegesByPrivilege(String privilege) {
		Optional<Privilege> optionalPrivilege = privilegeRepository.findByPrivilege(privilege);
        if (optionalPrivilege.isEmpty()) {
            throw new IllegalStateException("Privilege does not exist with Privilege " + privilege);
        }
        return optionalPrivilege.get();
	}
	
	@Override
	public Privilege getPrivilegesByDescription(String description) {
		Optional<Privilege> optionalPrivilege = privilegeRepository.findByDescription(description);
        if (optionalPrivilege.isEmpty()) {
            throw new IllegalStateException("Description does not exist with city " + description);
        }
        return optionalPrivilege.get();
	}

	@Override
	public Privilege updatePrivileges(Privilege newPrivilegesData, Long id) {
		Privilege existingPrivilege = getPrivilegesById_privilege(id);         
		return PrivilegeUpdater.updatePrivileges(existingPrivilege, newPrivilegesData);
	}

	@Override
	public void deletePrivileges(Long id) {
		Privilege existingPrivilege = getPrivilegesById_privilege(id); 
		savePrivileges(existingPrivilege);
	}

	

}

