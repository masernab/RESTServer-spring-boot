//package com.example.demo.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.model.Product;
//
//@Repository("fakeProductDao")
//public class FakeProductDataAccessService implements ProductDao{
//
//	public static List<Product> DBProduct = new ArrayList<>();
//
//	@Override
//	public List<Product> getProducts() {
//		return DBProduct;
//	}
//
//	@Override
//	public Product addProduct(UUID id, Product product) {
//		Product newProduct = new Product(id, product.getName(), product.getDesc(), product.getPrice());
//		DBProduct.add(newProduct);
//		return newProduct;
//	}
//
//	@Override
//	public Optional<Product> getProductById(UUID id) {
//		return DBProduct.stream().filter(produ -> produ.getId().equals(id)).findFirst();
//	}
//
//	@Override
//	public int updateProduct(UUID id, Product product) {
//		Product productUpdated = new Product(id, product.getName(), product.getDesc(), product.getPrice());
//		return getProductById(id).map(produ -> {
//			int indexProduct = DBProduct.indexOf(produ);
//			if(indexProduct >= 0) {
//				DBProduct.set(indexProduct, productUpdated);	
//				return 1;
//			}else {
//				return 0;
//			}
//		}).orElse(0);
//	}
//
//	@Override
//	public String deleteProduct(UUID id) {
//		return getProductById(id).map(produ -> {
//			int indexProduct = DBProduct.indexOf(produ);
//			if(indexProduct >= 0) {
//				DBProduct.remove(indexProduct);	
//				return "Borrado";
//			}else {
//				return "Error";
//			}
//		}).orElse("Error");
//	}
//}
