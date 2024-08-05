package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Orders;
import com.yoatzin.app.repository.OrderRepository;
import com.yoatzin.app.service.OrderService;

@Service // Indica que esta clase es un servicio de Spring.
public class OrderServiceImpl implements OrderService {
    
    private final OrderRepository orderRepository;

    // Constructor con inyección de dependencias.
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Orders createOrder(Orders order) {
        order.setId_order(null); // Asegura que la ID sea generada automáticamente.
        return saveOrder(order); // Guarda la orden.
    }

    private Orders saveOrder(Orders order) {
        return orderRepository.save(order); // Método privado para guardar la orden.
    }

    @Override
    public Orders getOrderById(Long id) {
        Optional<Orders> optionalOrder = orderRepository.findById(id); // Busca la orden por ID.
        if (optionalOrder.isEmpty()) {
            throw new IllegalStateException("El pedido no existe con el id " + id); // Lanza excepción si no existe.
        }
        return optionalOrder.get(); // Retorna la orden si existe.
    }

    @Override
    public Iterable<Orders> getAllOrders() {
        return orderRepository.findAll(); // Retorna todas las órdenes.
    }

    @Override
    public Orders updateOrder(Orders newOrderData, Long id) {
        Orders existingOrder = getOrderById(id); // Busca la orden existente.
        existingOrder.setQuantity(newOrderData.getQuantity()); // Actualiza los datos de la orden.
        existingOrder.setPartial_amount(newOrderData.getPartial_amount());
        existingOrder.setDate(newOrderData.getDate());
        existingOrder.setFk_id_user(newOrderData.getFk_id_user());
        existingOrder.setFk_id_card(newOrderData.getFk_id_card());
        existingOrder.setFk_id_address(newOrderData.getFk_id_address());
        return saveOrder(existingOrder); // Guarda la orden actualizada.
    }

    @Override
    public void deleteOrder(Long id) {
        Orders existingOrder = getOrderById(id); // Busca la orden existente.
        orderRepository.delete(existingOrder); // Elimina la orden.
    }
}

