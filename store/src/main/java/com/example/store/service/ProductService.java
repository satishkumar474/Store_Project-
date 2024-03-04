package com.example.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.entity.Product;
import com.example.store.repository.ProductRepository;

@Service

public class ProductService {
	private final ProductRepository productrepository;
	
	@Autowired
	
	public ProductService(ProductRepository productRepository) {
		this.productrepository = productRepository;
	}
	public List<Product> getAllPorducts(){
		return productrepository.findAll();
	}
	public Optional<Product> getProductById(Long id) {
        Optional<Product> BBB = productrepository.findById(id);
        return BBB;
	}
	public Product saveOrUpdateProduct(Product product) {
        Product AAA = productrepository.save(product);
        return AAA;
    }
	public void deleteProduct(Long id) {
        productrepository.deleteById(id);
    }
	

}
