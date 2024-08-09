package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Size;

public interface SizeRepository extends CrudRepository<Size, Long> {
	Optional<Size> findBySize(String size);
}
