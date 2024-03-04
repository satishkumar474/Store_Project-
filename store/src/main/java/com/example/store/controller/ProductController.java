package com.example.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.entity.Product;
import com.example.store.service.ProductService;

@RestController
public class ProductController {
	
	   private final ProductService productService;

	    @Autowired
	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    // Endpoint to retrieve all products
	    @GetMapping("/product")
	    public ResponseEntity<List<Product>> getAllProducts() {
	        List<Product> products = productService.getAllPorducts();
	        return new ResponseEntity<>(products, HttpStatus.OK);
	    } 
	    @GetMapping("/getById/{Id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long Id) {
	    	Optional<Product> product = productService.getProductById(Id);
	        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }
	    @PostMapping("/create")
	    public ResponseEntity<Product> saveOrUpdateProduct(@RequestBody Product product) {
	        Product savedProduct = productService.saveOrUpdateProduct(product);
	        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	    }
	    //@RequestBody --> to accept the payload
	    //@PathVarible --> to Accept a single varible
	    
	    
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    
	    } 
	    
	

}
