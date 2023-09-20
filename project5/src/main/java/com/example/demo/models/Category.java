package com.example.demo.models;

import java.util.Set;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name ="Category")
public class Category {
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Mã số tự động tạo
	
	@Column(length = 50)
	private String name;
	
	//quan hệ nhiều 1 với bảng product  (products)
	@OneToMany(mappedBy = "category")
	private Set<Product> products ;
	



	public Category(Long id) {
		super();
		this.id = id;
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Category() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
}
