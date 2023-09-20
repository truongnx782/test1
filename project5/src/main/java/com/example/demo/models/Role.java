package com.example.demo.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Mã số tự động tạo
	
	@Column(length = 50)
	private String name;
	
	//quan hệ 1 nhiều với bảng 
	@OneToMany(mappedBy = "role")
	private Set<User> users;

	public Role(Long id, String name, Set<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.users = user;
	}

	
	public Role() {
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

	public Set<User> getUser() {
		return users;
	}

	public void setUser(Set<User> user) {
		this.users = user;
	}
	
	
	
}
