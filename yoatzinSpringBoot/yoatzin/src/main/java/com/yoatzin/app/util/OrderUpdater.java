package com.yoatzin.app.util;

import com.yoatzin.app.model.Orders;

public final class OrdersUpdater {

    private OrdersUpdater() {}

    public static Orders updateOrder(Orders existingOrder, Orders newOrderData) {
        if (existingOrder == null || newOrderData == null) {
            throw new IllegalArgumentException("Order data cannot be null");
        }

        existingOrder.setQuantity(newOrderData.getQuantity() != 0 ? newOrderData.getQuantity() : existingOrder.getQuantity());
        existingOrder.setDate(newOrderData.getDate() != null ? newOrderData.getDate() : existingOrder.getDate());
        existingOrder.setFkIdCard(newOrderData.getFkIdCard() != null ? newOrderData.getFkIdCard() : existingOrder.getFkIdCard());
        existingOrder.setFkIdAddress(newOrderData.getFkIdAddress() != null ? newOrderData.getFkIdAddress() : existingOrder.getFkIdAddress());
        existingOrder.setFkIdUser(newOrderData.getFkIdUser() != null ? newOrderData.getFkIdUser() : existingOrder.getFkIdUser());

        return existingOrder;
    }
}
