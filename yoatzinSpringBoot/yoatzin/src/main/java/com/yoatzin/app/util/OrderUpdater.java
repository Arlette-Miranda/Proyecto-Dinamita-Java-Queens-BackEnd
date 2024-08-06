package com.yoatzin.app.util;

import com.yoatzin.app.model.Order;

public final class OrderUpdater {
    private OrderUpdater() {}

    public static Order updateOrder(Order existingOrder, Order newOrderData) {
        if (existingOrder == null || newOrderData == null) {
            throw new IllegalArgumentException("Order data cannot be null");
        }

        existingOrder.setQuantity(newOrderData.getQuantity());
        existingOrder.setDate(newOrderData.getDate());
        existingOrder.setUser(newOrderData.getUser());
        existingOrder.setCard(newOrderData.getCard());
        existingOrder.setAddress(newOrderData.getAddress());

        return existingOrder;
    }
}
