package com.yoatzin.app.service;

import com.yoatzin.app.model.Order;
import java.util.Optional;

@Service
public interface OrderService {
    Order createOrder(Order order); // Método para crear una orden.

    Optional<Order> getOrderById(Long id); // Método para obtener una orden por ID.

    Iterable<Order> getAllOrders(); // Método para obtener todas las órdenes.

    Order updateOrder(Long id, Order newOrderData); // Método para actualizar una orden.

    void deleteOrder(Long id); // Método para eliminar una orden.
}
