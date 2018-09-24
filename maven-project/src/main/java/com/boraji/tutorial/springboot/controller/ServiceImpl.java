package com.boraji.tutorial.springboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ServiceImpl implements Service {


@Autowired
TokenGenerator tokengenerator = new TokenGeneratorImpl();



Map<String, Integer> tokencache = new HashMap<String, Integer>();
	

	@Override
	public int login(String username, String password) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		
		Query query= session.createQuery("from User where username = :username");
		query.setParameter("username", username);
		List<User> users = query.list();
	    session.getTransaction().commit();
	    System.out.println("The size is");
	    	System.out.println(users.size());
	    
		if(password.equals(users.get(0).getPassword())) {
		int token=tokengenerator.createToken(username);
		tokencache.put(username, token);
		return token;
		}
		else {
			return -1;
		}
	}


	@Override
	public void order(int id,String name,String serviceitem,String price,int token,String username) {
		//if(token==tokencache.get(username)) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Item itemobj= new Item();
			itemobj.setId(id);
			
			itemobj.setService(serviceitem);
			
			itemobj.setItem(name);
			
			itemobj.setPrice(price);
			itemobj.setUsername(username);
			session.save(itemobj);
			//}
			session.close();
	}


	@Override
	public List<Product> products() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
	  List<Product> items = session.createQuery("from Product").list();
	  
	  
	  
	  
	    session.getTransaction().commit();
	    session.close();
		return items;
		
	}


	@Override
	public void create(String username, String password, String confirmpassword) {
		
		char[] passwordarray=password.toCharArray();
		char[] confirmedpasswordarray=confirmpassword.toCharArray();
		
		Arrays.sort(passwordarray);
		Arrays.sort(confirmedpasswordarray);
		
		if(Arrays.equals(passwordarray,confirmedpasswordarray)) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		session.save(user);
		session.close();
		}
	

	
	
	
}


	@Override
	public void remove(String id) {
		Session session ;
	    Item item ;
int idx= Integer.parseInt(id);
	    session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();
	    item = (Item)session.load(Item.class,idx);
	    session.delete(item);

	    //This makes the pending delete to be done
	    session.flush() ;
	    tx.commit();
	    session.close();
	}
	
}
