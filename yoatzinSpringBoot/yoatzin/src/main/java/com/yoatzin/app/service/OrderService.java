package com.yoatzin.app.service;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Order;

@Service
public interface OrderService {
    Order createOrder(Order order); // Método para crear una orden.

    Order getOrderById(Long id); // Método para obtener una orden por ID.

    Iterable<Order> getAllOrders(); // Método para obtener todas las órdenes.

    Order updateOrder(Order newOrderData, Long id); // Método para actualizar una orden.

    void deleteOrder(Long id); // Método para eliminar una orden.
}
