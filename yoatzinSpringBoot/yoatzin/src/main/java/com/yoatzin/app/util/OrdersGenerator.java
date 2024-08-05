package com.yoatzin.app.util;

import com.yoatzin.app.dto.OrdersDto;
import com.yoatzin.app.model.Orders;

public class OrdersGenerator {
    public static Orders fromDto(OrdersDto ordersDto) {
        Orders order = new Orders();
        order.setFk_id_user(ordersDto.getFk_id_user());
        order.setFk_id_card(ordersDto.getFk_id_card());
        order.setFk_id_address(ordersDto.getFk_id_address());
        order.setQuantity(ordersDto.getQuantity());
        order.setDate(ordersDto.getDate());
        return order;
    }
}
