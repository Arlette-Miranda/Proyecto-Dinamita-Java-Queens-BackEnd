package com.yoatzin.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Long> {

}
