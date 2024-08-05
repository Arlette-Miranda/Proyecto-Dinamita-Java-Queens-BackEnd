package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Privilege;

@Service
public interface PrivilegeService {
	//public Privilege createPrivileges(Privilege privileges);
	Privilege createPrivileges(Privilege privilege);
	Privilege getPrivilegesById_privilege(Long id_privilege); 
	Privilege getPrivilegesByDescription(Long description); 
	Iterable<Privilege> getAllActivePrivileges();
	Iterable<Privilege> getAllInactivePrivileges();
	Iterable<Privilege> getAllPrivileges(boolean isActive);
	Privilege updatePrivileges(Privilege privilges, Long id_privileges);
	void deletePrivileges(Long id_privileges);
	
}
