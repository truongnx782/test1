package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryServiceIMPL implements CategoryService{
@Autowired
CategoryRepository categoryRepository;

@Override
public List<Category> findAll() {
	return (List<Category>) categoryRepository.findAll();
}


}
