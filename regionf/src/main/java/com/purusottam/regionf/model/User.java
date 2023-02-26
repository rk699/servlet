package com.purusottam.regionf.model;

public class User {
	
	protected int id;
	protected String name;
	protected String email;
	protected String phone;
	protected String address;
	protected String pincode;
	
	
	public User() {
	}


	public User(String name, String email, String phone, String address, String pincode) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.pincode = pincode;
	}


	public User(int id, String name, String email, String phone, String address, String pincode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.pincode = pincode;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	

}
