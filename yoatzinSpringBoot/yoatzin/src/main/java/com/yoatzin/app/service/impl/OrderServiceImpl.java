package com.yoatzin.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Orders;
import com.yoatzin.app.repository.OrdersRepository;
import com.yoatzin.app.service.OrdersService;

@Service // Indica que esta clase es un servicio de Spring.
public class OrdersServiceImpl implements OrdersService {

    @Autowired // Inyección de dependencias de Spring.
    private OrdersRepository ordersRepository;

    @Override
    public Orders createOrder(Orders order) {
        return ordersRepository.save(order); // Guarda la orden en la base de datos.
    }

    @Override
    public Orders getOrderById(Long id) {
        return ordersRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Order not found with id " + id));
    }

    @Override
    public Iterable<Orders> getAllOrders() {
        return ordersRepository.findAll(); // Devuelve todas las órdenes.
    }

    @Override
    public Orders updateOrder(Orders newOrderData, Long id) {
        Orders existingOrder = getOrderById(id);
        existingOrder.setQuantity(newOrderData.getQuantity());
        existingOrder.setDate(newOrderData.getDate());
        existingOrder.setFkIdCard(newOrderData.getFkIdCard());
        existingOrder.setFkIdAddress(newOrderData.getFkIdAddress());
        existingOrder.setFkIdUser(newOrderData.getFkIdUser()); // Actualiza la orden.
        return ordersRepository.save(existingOrder); // Guarda la orden actualizada.
    }

    @Override
    public void deleteOrder(Long id) {
        Orders existingOrder = getOrderById(id);
        ordersRepository.delete(existingOrder); // Elimina la orden.
    }
}
