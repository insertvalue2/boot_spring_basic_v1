package com.example.exception2.dto;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private String statuCode;
	private String requestUrl;
	private String code; 
	private String message; 
	private String resultCode; 
	
	List<MyError> errorList;
}
