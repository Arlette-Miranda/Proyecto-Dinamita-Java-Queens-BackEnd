package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	Optional<Privilege> findByIdPrivilege(Long id_privilege);
	Optional<Privilege> findByPrivilege(String privilege);
    Optional<Privilege> findByDescription(String description);
	

}

