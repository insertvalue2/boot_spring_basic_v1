package com.example.exception2.dto;

import lombok.Data;

@Data
public class MyError {
	
	private String field; 
	private String message; 
	private String invalideValue;
}
