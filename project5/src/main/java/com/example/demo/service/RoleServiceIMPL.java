package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.models.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleServiceIMPL implements RoleService {
	@Autowired
	RoleRepository repository;
	@Override
	public List<Role> findAll() {
		return (List<Role>) repository.findAll();
	}
}
