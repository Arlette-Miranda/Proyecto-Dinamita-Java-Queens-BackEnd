package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Privileges;

public interface PrivilegesRepository extends CrudRepository<Privileges, Long> {

	Optional<Privileges> findById_Privilege(Long id_privilege);
	Iterable<Privileges> findAllByActiveTrue();
	Iterable<Privileges> findAllByActiveFalse();
	boolean existsById_Privileges(Long id_privilege);

}

