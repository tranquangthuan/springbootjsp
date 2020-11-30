package com.thuan.springboot.jsp.repository;

import org.springframework.data.repository.CrudRepository;

import com.thuan.springboot.jsp.entity.Product;

public interface ProductRepositoty extends CrudRepository<Product, Long> {

}
