package com.example.models;
/*
* Author: Kaiser-DEV
* created-dates: 01/24/2024
* */

public class Account {
	private String name;
	private String email;
	
	
	public Account() {
		super();
	}
	public Account(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	// return name
	public String getName() {
		return name;
	}
	// set name
	public void setName(String name) {
		this.name = name;
	}
	// return email
	public String getEmail() {
		return email;
	}
	// set email
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
