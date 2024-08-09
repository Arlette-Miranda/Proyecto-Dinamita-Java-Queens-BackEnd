package com.yoatzin.app.service;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.User;

@Service
public interface UserService {
	User createUser(User user);
	User getUserById(Long id);
	User getUserByEmail(String email);
	Iterable<User> getAllActiveUsers();
	Iterable<User> getAllInactiveUsers();
	Iterable<User> getAllUser(boolean isActive);
	User updateUser(User user, Long id);
	void deleteUser(Long id);
}

