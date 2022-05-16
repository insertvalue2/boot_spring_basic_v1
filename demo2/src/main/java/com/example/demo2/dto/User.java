package com.example.demo2.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

//null 값을 보내지 내려 주지 않음 
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	
	private String name; 
	private int age;
	private String phoneNumber;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
