package com.boraji.tutorial.springboot.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="item")
public class Item {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable= false)
private int id;
	@Column(name="item", unique=false, nullable= false, length=100)
private String item;
	@Column(name="service", unique=false, nullable= false, length=100)
private String service;
	@Column(name="price", unique=false, nullable= false, length=100)
private String price;
	@Column(name="username", unique=false, nullable= false, length=100)
private String username;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getItem() {
	return item;
}
public void setItem(String item) {
	this.item = item;
}
public String getService() {
	return service;
}
public void setService(String service) {
	this.service = service;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
}
