package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Products_has_orders;
import com.yoatzin.app.repository.Products_has_ordersRepository;
import com.yoatzin.app.service.Products_has_ordersService;

@Service
public class Products_has_ordersServiceImpl implements Products_has_ordersService {
    
    //@Autowired
    Products_has_ordersRepository products_has_ordersRepository;
    
    public Products_has_ordersServiceImpl(Products_has_ordersRepository products_has_ordersRepository) {
        this.products_has_ordersRepository = products_has_ordersRepository;
    }
    
    @Override
    public Products_has_orders createProducts_has_orders(Products_has_orders products_has_orders) {
        Products_has_orders newProducts_has_orders = products_has_ordersRepository.save(products_has_orders);
        return newProducts_has_orders;
    }
}
