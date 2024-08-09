package com.yoatzin.app.service.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yoatzin.app.model.Product;
import com.yoatzin.app.repository.ProductRepository;
import com.yoatzin.app.service.ProductService;
import com.yoatzin.app.util.ProductUpdater;

@Service
public class ProductServiceImpl implements ProductService {
    
    //@Autowired
    ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public Product createProducts(Product product) {
    	product.setIdProduct(null);
        Product newProducts = saveProducts(product);
        return newProducts;
    }
    
    private Product saveProducts(Product product) {
    	return productRepository.save(product);
    }

	@Override
	public Product getProductsById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Product does not exist with id " + id);
        }
        return optionalProduct.get();
	}

	@Override
	public Product getProductsByCategory(String category) {
		Optional<Product> optionalProduct = productRepository.findByCategory(category);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Product does not exist with category " + category);
        }
        return optionalProduct.get();
	}

	@Override
	public Product getProductsByStock(int stock) {
		Optional<Product> optionalProduct = productRepository.findByStock(stock);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Product does not exist with stock " + stock);
        }
        return optionalProduct.get();
	}

	@Override
	public Product updateProducts(Product newProductsData, Long id) {
		Product existingProduct = getProductsById(id);
        return ProductUpdater.updateProducts(existingProduct, newProductsData);
	}

	@Override
	public void deleteProducts(Long id) {
		Product existingProduct = getProductsById(id);
		saveProducts(existingProduct);
	}

	@Override
	public Product getProductsByName(String name) {
		Optional<Product> optionalProduct = productRepository.findByName(name);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Product does not exist with name " + name);
        }
        return optionalProduct.get();
	}

	@Override
	public Product getProductsByPrice(BigDecimal price) {
		Optional<Product> optionalProduct = productRepository.findByPrice(price);
        if (optionalProduct.isEmpty()) {
            throw new IllegalStateException("Product does not exist with price " + price);
        }
        return optionalProduct.get();
	}
}
