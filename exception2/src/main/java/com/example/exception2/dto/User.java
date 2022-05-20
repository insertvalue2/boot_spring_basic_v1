package com.example.exception2.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class User {
	
	@NotEmpty
	@Size(min = 2, max = 10)
	private String name; 
	@Min(1)
	@NotNull
	private Integer age; 
}
