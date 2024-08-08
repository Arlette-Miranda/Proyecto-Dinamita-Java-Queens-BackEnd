package com.yoatzin.app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.ProductHasOrder;
import com.yoatzin.app.model.composite_key.ProductOrderKey;
import com.yoatzin.app.repository.ProductHasOrderRepository;
import com.yoatzin.app.service.ProductHasOrderService;

@Service
public class ProductHasOrderServiceImpl implements ProductHasOrderService {
    
    //@Autowired
    ProductHasOrderRepository prHorRepository;
    
    public ProductHasOrderServiceImpl(ProductHasOrderRepository prHorRepository) {
        this.prHorRepository = prHorRepository;
    }

	@Override
	public ProductHasOrder createProductHasOrder(ProductHasOrder productHasOrder) {
		return prHorRepository.save( productHasOrder );
	}

	@Override
	public Iterable<ProductHasOrder> getProductHasOrder() {
		return prHorRepository.findAll();
	}

	@Override
	public ProductHasOrder getProductHasOrderByCompositeId(Long productId, Long orderId) {
		ProductOrderKey productOrderKey = new ProductOrderKey(productId, orderId);
		Optional<ProductHasOrder> optionalPrHor = prHorRepository.findById(productOrderKey);
		if( optionalPrHor.isEmpty()) {
			new IllegalStateException (
					"ProductHasOrder does not exist with productId: " +
			productId + " and orderId " + orderId);
		}
		return optionalPrHor.get();
	}

	@Override
	public Iterable<ProductHasOrder> getProductHasOrderByProductId(Long productId) {
		return prHorRepository.findAllByProductID(productId);
	}

	@Override
	public ProductHasOrder updateProductHasOrderByCompositeId(ProductHasOrder productHasOrder, long productId,
			long orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductHasOrderByCompositeId(Long productId, Long orderId) {
		ProductHasOrder prHor = getProductHasOrderByCompositeId(productId, orderId);
		prHorRepository.delete(prHor);
		
	}
}
