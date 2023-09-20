package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceIMPL implements ProductService {
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product save(Product entity) {
		return productRepository.save(entity);
	}

	@Override
	public Product findByMa(String maSP,String username) {
		return productRepository.findByMa(maSP,username);
	}


	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	

	@Override
	  @Transactional
	public void deleteById(Long id) {
		 productRepository.deleteById(id);
	}
	
	@Override
	public List<Product> findByCategory(String username,Long id) {
	return  productRepository.findByCategory( username,id);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAllByUsername(String username) {
		// TODO Auto-generated method stub
		return  productRepository.findAllByUsername(username);
	}

}
