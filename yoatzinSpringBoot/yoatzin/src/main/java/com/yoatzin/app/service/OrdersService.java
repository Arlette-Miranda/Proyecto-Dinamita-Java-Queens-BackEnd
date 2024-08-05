package com.yoatzin.app.service;

import com.yoatzin.app.model.Orders;

public interface OrderService {
    Orders createOrder(Orders order); // Método para crear una orden.

    Orders getOrderById(Long id); // Método para obtener una orden por ID.

    Iterable<Orders> getAllOrders(); // Método para obtener todas las órdenes.

    Orders updateOrder(Orders newOrderData, Long id); // Método para actualizar una orden.

    void deleteOrder(Long id); // Método para eliminar una orden.
}
