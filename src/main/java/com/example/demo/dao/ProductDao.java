package com.example.demo.dao;


//import java.util.List;
//import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Product;

public interface ProductDao extends MongoRepository<Product, String>{

//	public Product addProduct(Product product);
//	public List<Product> getProducts();
//	public Optional<Product> getProductById(String id);
//	public int updateProduct(String id, Product product);
//	public String deleteProduct(String id);
//	Product addProduct(String id, Product product);
}
