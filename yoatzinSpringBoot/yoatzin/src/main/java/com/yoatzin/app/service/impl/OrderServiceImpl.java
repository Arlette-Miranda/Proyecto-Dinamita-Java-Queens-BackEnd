package com.yoatzin.app.service.impl;

import com.yoatzin.app.model.Order;
import com.yoatzin.app.repository.OrderRepository;
import com.yoatzin.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        // Guardar y devolver la nueva orden
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        // Obtener la orden por ID
        return orderRepository.findById(id);
    }

    @Override
    public Iterable<Order> getAllOrders() {
        // Obtener todas las órdenes
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, Order newOrderData) {
        // Buscar la orden existente por ID
        return orderRepository.findById(id)
                .map(order -> {
                    // Actualizar los campos de la orden
                    order.setQuantity(newOrderData.getQuantity());
                    order.setDate(newOrderData.getDate());
                    order.setUser(newOrderData.getUser()); // Actualizar la relación con User
                    order.setCard(newOrderData.getCard()); // Actualizar la relación con Card
                    order.setAddress(newOrderData.getAddress()); // Actualizar la relación con Address
                    // Guardar y devolver la orden actualizada
                    return orderRepository.save(order);
                }).orElseThrow(() -> new IllegalArgumentException("Order not found")); // Lanza excepción si no se encuentra la orden
    }

    @Override
    public void deleteOrder(Long id) {
        // Eliminar la orden por ID
        orderRepository.deleteById(id);
    }
}
