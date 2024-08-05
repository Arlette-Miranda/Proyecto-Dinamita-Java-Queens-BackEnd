package com.yoatzin.app.service;

import com.yoatzin.app.dto.UserDto;
import com.yoatzin.app.model.User;

public interface UserDtoService {

	UserDto createUser(User user);
	UserDto getUserById(Long id);
	UserDto getUserByEmail(String email);
	Iterable<UserDto> getAllActiveUsers();
	Iterable<UserDto> getAllInactiveUsers();
	Iterable<UserDto> getAllUser(boolean isActive);
	UserDto updateUser(User user, Long id);
	void deleteUser(Long id);
}
