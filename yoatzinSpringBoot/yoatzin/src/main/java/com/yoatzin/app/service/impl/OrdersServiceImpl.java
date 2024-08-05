package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Orders;
import com.yoatzin.app.repository.OrdersRepository;
import com.yoatzin.app.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
    
    //@Autowired
    OrdersRepository ordersRepository;
    
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    
    @Override
    public Orders createOrders(Orders orders) {
        Orders newOrders = ordersRepository.save(orders);
        return newOrders;
    }
}
