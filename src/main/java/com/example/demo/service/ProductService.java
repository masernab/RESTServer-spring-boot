package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;

@Service
public class ProductService {

	private final ProductDao productDao;

	//para inyeccion de dependencia en el constructor
	@Autowired
	public ProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	public ResponseEntity<Product> addProduct(Product product) {
		try {
			Product productAdded = productDao.save(product);
			return new ResponseEntity<Product>(productAdded, HttpStatus.CREATED);	
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.CREATED);
		}
	}

	public ResponseEntity<List<Product>> getProduct() {
		try {
			List<Product> allProducts = productDao.findAll(); 
			if(allProducts.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Product>>(allProducts, HttpStatus.OK);	
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	public ResponseEntity<Optional<Product>> getProductById(String id) {
		try {
			Optional<Product> productFound = productDao.findById(id);
			if(productFound.isPresent()) {
				return new ResponseEntity<Optional<Product>>(productFound, HttpStatus.OK);		
			}else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Product> updateProduct(String id, Product product) {
		try {
			Optional<Product> productData = productDao.findById(id);
			if(productData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				Product productUpdated = productDao.save(new Product(id, product.getName(), product.getDesc(), product.getPrice()));
				return new ResponseEntity<Product>(productUpdated, HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HttpStatus> deleteProduct(String id) {
		try {
			Optional<Product> oldProduct = productDao.findById(id);
			if(oldProduct.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		    productDao.deleteById(id);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  } catch (Exception e) {
			System.out.println(e);
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
}
