package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.User;

public interface UserRepository extends CrudRepository<User, String> {


	 @Query(value = "SELECT * FROM users where username = :username", nativeQuery = true)
	Optional<User> findByUsername(@Param("username") String username);
	 
	 @Query(value = "SELECT * FROM users where email = :email", nativeQuery = true)
	Optional<User> findByEmail(@Param("email") String email);

	 @Query(value = "SELECT * FROM users where username = :username", nativeQuery = true)
	User findIdByUsername(@Param("username") String username);
	 
	 @Query(value = "SELECT * FROM users where username = :username and password = :password", nativeQuery = true)
	User checkLogin(@Param("username") String username,@Param("password") String password);


}
