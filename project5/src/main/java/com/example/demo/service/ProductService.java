package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.repository.ProductRepository;

public interface ProductService {

	List<Product> findByCategory(String username,Long id);

	List<Product> findAll();

	Product findByMa(String maSP, String username);

	Product save(Product entity);

	void deleteById(Long id);

	Optional<Product> findById(Long id);

	List<Product>  findAllByUsername(String username);



}
