package com.yoatzin.app.util;

import com.yoatzin.app.model.User;

public final class UserUpdater {
	
	private UserUpdater() {}
	
	public static User updateUser(User existingUser, User newUserData) {
		if (existingUser == null || newUserData == null) {
			throw new IllegalArgumentException("User data cannot be null");
		}
		
		existingUser.setName(newUserData.getName());
		existingUser.setLast_name(newUserData.getLast_name());
		existingUser.setPhone(newUserData.getPhone());
		existingUser.setEmail(newUserData.getEmail());
		existingUser.setPassword(newUserData.getPassword());
		
		return existingUser;
	}

}
