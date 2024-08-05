package com.yoatzin.app.service.impl;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Product_has_order;
import com.yoatzin.app.repository.Product_has_orderRepository;
import com.yoatzin.app.service.Product_has_orderService;

@Service
public class Product_has_orderServiceImpl implements Product_has_orderService {
    
    //@Autowired
    Product_has_orderRepository product_has_orderRepository;
    
    public Product_has_orderServiceImpl(Product_has_orderRepository product_has_orderRepository) {
        this.product_has_orderRepository = product_has_orderRepository;
    }
    
    @Override
    public Product_has_order createProducts_has_orders(Product_has_order product_has_order) {
        Product_has_order newProducts_has_orders = product_has_orderRepository.save(product_has_order);
        return newProducts_has_orders;
    }
}
