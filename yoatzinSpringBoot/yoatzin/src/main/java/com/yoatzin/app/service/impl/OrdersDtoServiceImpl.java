package com.yoatzin.app.service.impl;

import com.yoatzin.app.dto.OrdersDto;
import com.yoatzin.app.model.Orders;
import com.yoatzin.app.repository.OrderRepository;
import com.yoatzin.app.service.OrdersDtoService;
import com.yoatzin.app.util.OrdersGenerator;
import com.yoatzin.app.util.OrdersUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersDtoServiceImpl implements OrdersDtoService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrdersDto createOrder(OrdersDto ordersDto) {
        Orders order = OrdersGenerator.fromDto(ordersDto);
        Orders createdOrder = orderRepository.save(order);
        ordersDto.setId_order(createdOrder.getId_order());
        return ordersDto;
    }

    @Override
    public OrdersDto getOrderById(Long id) {
        Optional<Orders> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new IllegalStateException("Order not found with id " + id);
        }
        Orders order = optionalOrder.get();
        return new OrdersDto(order.getId_order(), order.getFk_id_user(), order.getFk_id_card(), order.getFk_id_address(), order.getQuantity(), order.getDate());
    }

    @Override
    public List<OrdersDto> getAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        return orders.stream().map(order -> new OrdersDto(order.getId_order(), order.getFk_id_user(), order.getFk_id_card(), order.getFk_id_address(), order.getQuantity(), order.getDate()))
                .collect(Collectors.toList());
    }

    @Override
    public OrdersDto updateOrder(Long id, OrdersDto ordersDto) {
        Orders existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Order not found with id " + id));
        Orders updatedOrder = OrdersUpdater.updateOrder(existingOrder, ordersDto);
        orderRepository.save(updatedOrder);
        return ordersDto;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
