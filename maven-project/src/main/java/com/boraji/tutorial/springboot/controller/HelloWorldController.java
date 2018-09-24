package com.boraji.tutorial.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	Service service;
	
	
	
	
	
   @RequestMapping("/")
   public String sayHello() {
	
	   return "Hello Spring Boot!!";
      
   }
   
   @RequestMapping("/login")
   public int login(@RequestParam("username")String username, @RequestParam("password")String password) {
	   
	   return service.login(username, password);   
	   
   }
   
   
   @RequestMapping("/order")
   public void order(@RequestParam("id")int id, @RequestParam("item")String item, @RequestParam("service")String serviceitem, @RequestParam("price")String price) {
	   System.out.println(id);
	   System.out.println(item);
	   System.out.println(serviceitem);
	   System.out.println(price);

int token = 100;
String username="okkkkkk";
	   service.order(id, item, serviceitem, price, token, username);
	  
   }
   
   @RequestMapping("/products")
   public List<Product> products() {
	   
	   return service.products();
   }
   
   @RequestMapping("/remove")
   public void remove(@RequestParam("id") String id) {
	   service.remove(id);
   }
   @RequestMapping("/create")
   public void create(String username, String password, String confirmedpassword) {
	   System.out.print("create trigger"+username+password+confirmedpassword);
	   service.create(username, password, confirmedpassword);
   }
   
   
   
}