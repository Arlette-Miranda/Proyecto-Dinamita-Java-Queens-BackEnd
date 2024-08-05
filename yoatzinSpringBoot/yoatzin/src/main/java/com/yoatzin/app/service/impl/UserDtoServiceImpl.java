package com.yoatzin.app.service.impl;

import com.yoatzin.app.dto.UserDto;
import com.yoatzin.app.model.User;
import com.yoatzin.app.service.UserDtoService;
import com.yoatzin.app.service.UserService;

public class UserDtoServiceImpl implements UserDtoService {
	
	UserService userService;
	
	public UserDtoServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDto createUser(User user) {
		User newUser = userService.createUser(user);
		UserDto newUserDto = new UserDto();
		newUserDto.setSerialNumber( newUser.getId() );
		newUserDto.setName( newUser.getName() );
		newUserDto.setLast_name( newUser.getLast_name() );
		newUserDto.setEmail( newUser.getEmail() );
		newUserDto.setPhone( newUser.getPhone() );
		
		return newUserDto;
	}

	@Override
	public UserDto getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserDto> getAllActiveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserDto> getAllInactiveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<UserDto> getAllUser(boolean isActive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto updateUser(User user, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}

}
