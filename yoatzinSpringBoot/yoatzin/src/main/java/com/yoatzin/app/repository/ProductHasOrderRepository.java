package com.yoatzin.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yoatzin.app.model.ProductHasOrder;
import com.yoatzin.app.model.composite_key.ProductOrderKey;

public interface ProductHasOrderRepository extends CrudRepository<ProductHasOrder, ProductOrderKey> {

	List<ProductHasOrder> findAllByProductID(Long productId);
}

