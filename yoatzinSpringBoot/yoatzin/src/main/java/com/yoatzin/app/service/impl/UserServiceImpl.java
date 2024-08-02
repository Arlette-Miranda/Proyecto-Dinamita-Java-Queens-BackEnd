package com.yoatzin.app.service.impl;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.User;
import com.yoatzin.app.repository.UserRepository;
import com.yoatzin.app.service.UserService;
import com.yoatzin.app.util.UserUpdater;

@Service

public class UserServiceImpl implements UserService {
	
	//@Autowired
	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User createUser(User user) {
		String email = user.getEmail();
		if( userRepository.existsByEmail(email) ) {
			throw new IllegalStateException("The email " + email + " is already registered.");
		}
		user.setId(null);
		user.setActive(true);
		User newUser = saveUser(user);
		return newUser;
		
	}
	
	private User saveUser(User user) {
		return userRepository.save( user);
		
	}
	
	@Override
	public User getUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isEmpty() ) {
			throw new IllegalStateException("User does not exist with id " + id);
		}
		return optionalUser.get();
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if (optionalUser.isEmpty() ) {
			throw new IllegalStateException("User does not exist with email " + email);
		}
		return optionalUser.get();
	}

	@Override
	public Iterable<User> getAllActiveUsers() {
		return userRepository.findAllByActiveTrue();
	}

	@Override
	public Iterable<User> getAllInactiveUsers() {
		return userRepository.findAllByActiveFalse();
	}

	@Override
	public Iterable<User> getAllUser(boolean isActive) {
		if(isActive) {
			return getAllActiveUsers();
		}
		return getAllInactiveUsers();
	}

	@Override
	public User updateUser(User newUserData, Long id) {
		User existingUser = getUserById(id);
		return UserUpdater.updateUser(existingUser, newUserData);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = getUserById(id);
		existingUser.setActive(false);
		saveUser(existingUser);		
		
	}

}
