package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.User;

public interface UserService {

	User checkLogin(String username, String password);

	void delete(User entity);

	void deleteById(String id);

	List<User> findAll();

	Optional<User> findById(String id);

	User save(User entity);

	Optional<User> findByUserName(String username);
	Optional<User> findByEmail(String email);

	User findIdByUsername(String username);



}
