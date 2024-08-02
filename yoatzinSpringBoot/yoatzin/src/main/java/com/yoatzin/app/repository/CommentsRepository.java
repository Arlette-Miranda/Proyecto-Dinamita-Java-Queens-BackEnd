package com.yoatzin.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Comments;

public interface CommentsRepository extends CrudRepository<Comments, Long> {

}
