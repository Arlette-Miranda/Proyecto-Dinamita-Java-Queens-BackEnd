package com.yoatzin.app.repository;

import org.springframework.data.repository.CrudRepository; // Interface que provee operaciones CRUD.
import org.springframework.stereotype.Repository;

import com.yoatzin.app.model.Order;

@Repository // Indica que esta clase es un repositorio de Spring.
public interface OrderRepository extends CrudRepository<Order, Long> {
    // No se necesitan métodos adicionales, CrudRepository proporciona CRUD básico.
}

