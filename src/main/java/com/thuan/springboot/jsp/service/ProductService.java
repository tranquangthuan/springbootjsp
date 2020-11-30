package com.thuan.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import com.thuan.springboot.jsp.entity.Product;

public interface ProductService {

	Product save(Product product);

	List<Product> getProducts();

	void deleteById(long id);

	Optional<Product> findById(long id);

}
