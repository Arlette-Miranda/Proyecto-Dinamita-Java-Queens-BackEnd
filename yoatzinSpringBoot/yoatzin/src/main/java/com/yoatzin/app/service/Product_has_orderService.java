package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Product_has_order;

@Service
public interface Product_has_orderService {

	Product_has_order createProducts_has_orders(Product_has_order product_has_order);

}
