package com.yoatzin.app.repository;
import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Cards;

public interface CardsRepository extends CrudRepository<Cards, Long> {

}

