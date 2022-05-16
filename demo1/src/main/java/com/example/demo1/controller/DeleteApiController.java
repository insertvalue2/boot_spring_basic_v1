package com.example.demo1.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

	// http://localhost:8080/api/delete/[123]?account="myName"
	@DeleteMapping("delete/{userId}")
	public String delete(@PathVariable String userId, @RequestParam String account) {
		System.out.println("userId : " + userId);
		System.out.println("account :  " + account);
		
		return userId + ", " + account;
	}
}
