package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByEmail(String email);
	Iterable<User> findAllByActiveTrue();
	Iterable<User> findAllByActiveFalse();
	boolean existsByEmail(String email);

}
