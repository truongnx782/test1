package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Product;
import com.example.demo.models.User;


public interface ProductRepository extends CrudRepository<Product, String> {


	 @Query(value = "SELECT * FROM products join users on products.user_id= users.id where  maSP = :maSP and users.username = :username", nativeQuery = true)
	 Product  findByMa(@Param("maSP") String maSP,@Param("username")String username);

	 @Modifying
	    @Query(value = "DELETE FROM products WHERE id = :id", nativeQuery = true)
	    void deleteById(@Param("id") Long id);

	 @Query(value = "  SELECT * FROM products join users on products.user_id= users.id where users.username = :username and category_id = :id", nativeQuery = true)
	List<Product> findByCategory(@Param("username")String username, @Param("id") Long id);

	 
	 @Query(value = "SELECT * FROM products where id = :id", nativeQuery = true)
	 Optional<Product>  findById(Long id);

	 @Query(value = "  SELECT * FROM products join users on products.user_id= users.id where users.username = :username", nativeQuery = true)
	List<Product> findAllByUsername(@Param("username")String username);


	

	


}
