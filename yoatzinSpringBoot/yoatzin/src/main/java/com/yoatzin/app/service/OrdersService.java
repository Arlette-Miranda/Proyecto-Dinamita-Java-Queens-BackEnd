package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Orders;

@Service
public interface OrdersService {

	Orders createOrders(Orders orders);

}
