package com.yoatzin.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Sizes;

public interface SizesRepository extends CrudRepository<Sizes, Long> {
	Optional<Sizes> findBySize(String size);
}
