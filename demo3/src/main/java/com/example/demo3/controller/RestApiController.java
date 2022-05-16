package com.example.demo3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.models.User;

@RestController
@RequestMapping("/api")
public class RestApiController {

//	@GetMapping("/get/{id}")
//	public void get(@PathVariable Long id, @RequestParam String name) {
//		System.out.println("method : get");
//		System.out.println("method : get id --> " +  id);
//		System.out.println("method : get name --> " + name);
//	}
//	
//	@PostMapping("/post")
//	public void post(@RequestBody User user) {
//		System.out.println("==== method : post ===== ");
//		System.out.println(user);
//	}
	
	@GetMapping("/get/{id}")
	public String get(@PathVariable Long id, @RequestParam String name) {
		return id + " " + name; 
	}
	
	@PostMapping("/post")
	public User post(@RequestBody User user) {
		return user;
	}
	
}
