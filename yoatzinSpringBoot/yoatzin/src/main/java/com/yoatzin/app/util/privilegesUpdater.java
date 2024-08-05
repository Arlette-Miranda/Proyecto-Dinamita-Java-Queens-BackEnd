package com.yoatzin.app.util;

import com.yoatzin.app.model.Privileges;

public final class privilegesUpdater {
	
	@SuppressWarnings("unused")
	private void PrivilegesUpDater() {}

	public static Privileges updatePrivileges(Privileges existingPrivileges, Privileges newPrivilegesData) {
		if (existingPrivileges == null || newPrivilegesData == null ) {
			throw new IllegalArgumentException("Privileges data cannot be null");
		}
		
		existingPrivileges.setId_privilege(newPrivilegesData.getId_privilege());
		existingPrivileges.setDescription(newPrivilegesData.getDescription());
		
		return existingPrivileges;
	}

}
