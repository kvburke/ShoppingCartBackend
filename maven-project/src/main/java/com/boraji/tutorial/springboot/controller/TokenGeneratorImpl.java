package com.boraji.tutorial.springboot.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;

@Controller
public class TokenGeneratorImpl implements TokenGenerator{

	@Override
	public int createToken(String username) {
		Random rand = new Random();
	int hashcode= rand.nextInt(1000);
	int code= (hashcode & 15);
		return code;
	}

}
