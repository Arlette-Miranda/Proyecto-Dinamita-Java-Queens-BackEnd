package com.yoatzin.app.service;

import com.yoatzin.app.dto.OrdersDto;

import java.util.List;

public interface OrdersDtoService {
    OrdersDto createOrder(OrdersDto ordersDto);
    OrdersDto getOrderById(Long id);
    List<OrdersDto> getAllOrders();
    OrdersDto updateOrder(Long id, OrdersDto ordersDto);
    void deleteOrder(Long id);
}
