package com.yoatzin.app.service;
import com.yoatzin.app.model.Privileges;

//@Service
public interface PrivilegesService {
	//public Privileges createPrivileges(Privileges privileges);
	Privileges createPrivileges(Privileges privileges);
	Privileges getPrivilegesById_privilege(Long id_privilege); 
	Privileges getPrivilegesByDescription(Long description); 
	Iterable<Privileges> getAllActivePrivileges();
	Iterable<Privileges> getAllInactivePrivileges();
	Iterable<Privileges> getAllPrivileges(boolean isActive);
	Privileges updatePrivileges(Privileges privilges, Long id_privileges);
	void deletePrivileges(Long id_privileges);
	
}
