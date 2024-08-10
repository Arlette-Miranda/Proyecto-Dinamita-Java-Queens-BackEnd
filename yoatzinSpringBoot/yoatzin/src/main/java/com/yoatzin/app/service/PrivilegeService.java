package com.yoatzin.app.service;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Privilege;

@Service
public interface PrivilegeService {
	
	//public Privilege createPrivileges(Privilege privileges);
	Privilege createPrivileges(Privilege privilege);
	Privilege getPrivilegesById_privilege(Long id_privilege); 
	Privilege updatePrivileges(Privilege privilges, Long id_privileges);
	Privilege getPrivilegesByPrivilege(String privilege);
	Privilege getPrivilegesByDescription(String description);
	void deletePrivileges(Long id_privileges);
	
	
	
}
