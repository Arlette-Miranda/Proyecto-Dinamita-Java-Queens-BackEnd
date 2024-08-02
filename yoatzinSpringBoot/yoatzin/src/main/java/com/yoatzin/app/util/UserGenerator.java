package com.yoatzin.app.util;

import java.util.ArrayList;
import java.util.List;

import com.yoatzin.app.model.User;

public final class UserGenerator {
	
	private UserGenerator() {}
	
	public static List<User> generateRandomUsers(int quantity) {
		List<User> users = new ArrayList<>();

		for (int i = 0; i < quantity; i++) {
			users.add(generateRandomUser());
		}

		return users;
	}

	private static User generateRandomUser() {
		return null;
	}

}
