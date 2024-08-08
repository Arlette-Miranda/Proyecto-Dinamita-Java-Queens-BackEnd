package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	Optional<Privilege> findById_Privilege(Long id_privilege);
	Iterable<Privilege> findAllByActiveTrue();
	Iterable<Privilege> findAllByActiveFalse();
	boolean existsById_Privileges(Long id_privilege);

}

