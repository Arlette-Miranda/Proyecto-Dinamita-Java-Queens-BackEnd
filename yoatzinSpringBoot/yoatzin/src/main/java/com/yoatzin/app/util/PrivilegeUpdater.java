package com.yoatzin.app.util;

import com.yoatzin.app.model.Privilege;

public final class PrivilegeUpdater {
	
	
	private PrivilegeUpdater() {}

	public static Privilege updatePrivileges(Privilege existingPrivileges, Privilege newPrivilegesData) {
		if (existingPrivileges == null || newPrivilegesData == null ) {
			throw new IllegalArgumentException("Privilege data cannot be null");
		}
		
		existingPrivileges.setIdPrivilege(newPrivilegesData.getIdPrivilege());
		existingPrivileges.setDescription(newPrivilegesData.getDescription());
		
		return existingPrivileges;
	}

}
