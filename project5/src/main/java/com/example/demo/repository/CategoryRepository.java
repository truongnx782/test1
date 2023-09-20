package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Category;

public interface CategoryRepository extends CrudRepository<Category, String>{

}
