package com.boraji.tutorial.springboot.controller;


import java.util.List;


public interface Service {

	
	public int login(String username, String password);
	public void order(int id,String name,String item,String price,int token,String username);
	public List<Product> products();
	public void remove(String id);
	public void create(String username, String password, String confirmpassword);
	
}
