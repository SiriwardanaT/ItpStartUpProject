package com.project.model;

public class User {
	private String username;
	private int age;
	private String address;
	
	public User(String username, int age, String address) {
		super();
		this.username = username;
		this.age = age;
		this.address = address;
	}
	public User() {
		
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
