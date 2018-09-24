package com.boraji.tutorial.springboot.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;






@Entity
@Table(name="usertable", uniqueConstraints = {
		@UniqueConstraint(columnNames="username"),
		@UniqueConstraint(columnNames="password")})
public class User {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="idValue", unique=true, nullable= false)
int idValue;

@Column(name="username", unique=true, nullable= false, length=100)
String username;

@Column(name="password", unique=false, nullable= false, length=100)
String password;
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





}
