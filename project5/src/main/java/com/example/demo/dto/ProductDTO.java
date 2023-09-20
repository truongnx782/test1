package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

public class ProductDTO {



private Long id; 
private String maSP;
private String name;
private Double price;
private int quantity;
private String description;
private MultipartFile photo;
private String volume;
private Long categoryId;
private Long userID;

public ProductDTO() {
	super();
}

public ProductDTO(String maSP, String name, Double price, int quantity, String description, MultipartFile photo,
		String volume, Long categoryId, Long userID) {
	super();
	this.maSP = maSP;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.description = description;
	this.photo = photo;
	this.volume = volume;
	this.categoryId = categoryId;
	this.userID = userID;
}

public ProductDTO(Long id, String maSP, String name, Double price, int quantity, String description,
		MultipartFile photo, String volume, Long categoryId, Long userID) {
	super();
	this.id = id;
	this.maSP = maSP;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
	this.description = description;
	this.photo = photo;
	this.volume = volume;
	this.categoryId = categoryId;
	this.userID = userID;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getMaSP() {
	return maSP;
}

public void setMaSP(String maSP) {
	this.maSP = maSP;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public MultipartFile getPhoto() {
	return photo;
}

public void setPhoto(MultipartFile photo) {
	this.photo = photo;
}

public String getVolume() {
	return volume;
}

public void setVolume(String volume) {
	this.volume = volume;
}

public Long getCategoryId() {
	return categoryId;
}

public void setCategoryId(Long categoryId) {
	this.categoryId = categoryId;
}

public Long getUserID() {
	return userID;
}

public void setUserID(Long userID) {
	this.userID = userID;
}

}
