package com.yoatzin.app.util;

import com.yoatzin.app.dto.OrdersDto;
import com.yoatzin.app.model.Orders;

public class OrdersUpdater {
    public static Orders updateOrder(Orders existingOrder, OrdersDto newOrderData) {
        existingOrder.setFk_id_user(newOrderData.getFk_id_user());
        existingOrder.setFk_id_card(newOrderData.getFk_id_card());
        existingOrder.setFk_id_address(newOrderData.getFk_id_address());
        existingOrder.setQuantity(newOrderData.getQuantity());
        existingOrder.setDate(newOrderData.getDate());
        return existingOrder;
    }
}
