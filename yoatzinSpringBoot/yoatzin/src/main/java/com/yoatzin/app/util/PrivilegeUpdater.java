package com.yoatzin.app.util;

import com.yoatzin.app.model.Privilege;

public final class PrivilegeUpdater {
	
	@SuppressWarnings("unused")
	private void PrivilegesUpDater() {}

	public static Privilege updatePrivileges(Privilege existingPrivileges, Privilege newPrivilegesData) {
		if (existingPrivileges == null || newPrivilegesData == null ) {
			throw new IllegalArgumentException("Privilege data cannot be null");
		}
		
		existingPrivileges.setId_privilege(newPrivilegesData.getId_privilege());
		existingPrivileges.setDescription(newPrivilegesData.getDescription());
		
		return existingPrivileges;
	}

}
