package com.example.demo.models;


import java.util.Date;
import java.util.Set;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name ="Users")
public class User {
@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Mã số tự động tạo
	
	@Column(length = 50, unique = true, nullable = false)
	private String username;
	
	@Column(length = 50)
	private String password ;
	
	@Column(length = 50, unique = true, nullable = false)
	private String email;
	
    private boolean gender;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    

	
	@OneToMany(mappedBy = "user")
	private Set<Product> products ;
	
	@ManyToOne
	@JoinColumn(name="RoleId", referencedColumnName = "id")
	private Role role;







	public User(Long id, String username, String password, String email, boolean gender, Date birthday,
			Set<Product> products, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.products = products;
		this.role = role;
	}



	public User(Long id) {
		super();
		this.id = id;
	}



	public User() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isGender() {
		return gender;
	}



	public void setGender(boolean gender) {
		this.gender = gender;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public Set<Product> getProducts() {
		return products;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
