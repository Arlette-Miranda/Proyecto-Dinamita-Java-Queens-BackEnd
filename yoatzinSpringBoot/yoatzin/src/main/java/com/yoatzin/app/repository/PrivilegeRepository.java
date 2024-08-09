package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yoatzin.app.model.Privilege;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "privileges", path="privileges")
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {

	Optional<Privilege> findByIdPrivilege(Long id_privilege);
	Optional<Privilege> findByPrivilege(String privilege);
    Optional<Privilege> findByDescription(String description);
	

}

