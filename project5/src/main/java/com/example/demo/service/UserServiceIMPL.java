package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceIMPL implements UserService {
	@Autowired
	UserRepository repository;

@Override
public User save(User entity) {
	return repository.save(entity);
}


@Override
public Optional<User> findById(String id) {
	return repository.findById(id);
}


@Override
public List<User> findAll() {
	return(List<User>) repository.findAll();
}

@Override
public void deleteById(String id) {
	repository.deleteById(id);
}

@Override
public void delete(User entity) {
	repository.delete(entity);
}

@Override
public User checkLogin(String username, String password) {
return repository.checkLogin(username,password);
}


@Override
public Optional<User> findByUserName(String username) {
	// TODO Auto-generated method stub
	return repository.findByUsername(username);
}

@Override
public Optional<User> findByEmail(String username) {
	// TODO Auto-generated method stub
	return repository.findByEmail(username);
}


@Override
public User findIdByUsername(String username) {
	// TODO Auto-generated method stub
	return repository.findIdByUsername(username);
}


}



	

