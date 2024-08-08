package com.yoatzin.app.service;
import org.springframework.stereotype.Service;

import com.yoatzin.app.model.ProductHasOrder;

@Service
public interface ProductHasOrderService {

	ProductHasOrder createProductHasOrder(ProductHasOrder productHasOrder);
	Iterable<ProductHasOrder> getProductHasOrder();
	ProductHasOrder getProductHasOrderByCompositeId(Long productId, Long orderId);
	Iterable<ProductHasOrder> getProductHasOrderByProductId(Long productId);
	ProductHasOrder updateProductHasOrderByCompositeId(ProductHasOrder productHasOrder, long productId, long orderId);
	void deleteProductHasOrderByCompositeId(Long productId, Long orderId);	

}
