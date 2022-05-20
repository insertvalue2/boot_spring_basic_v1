package com.example.exception1.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception1.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/test")
	public String test1() {

		return "ok";
	}

//	예외 처리 하기 
	@GetMapping("/user")
	public User get(@RequestParam String name, @RequestParam int age) {

		User user = new User();
		// user.setName(name1);
		// user.setAge(age);
		// int sum = age + 10;
		return user;
	}

	@PostMapping("/user")
	public User post(@Valid @RequestBody User user) {
		System.out.println(user);
		return user;
	}

	// 해당 컨트롤러에서만 처리하고 싶다면
	// MethodArgumentNotValidException (json 에서 argument를 보내지 않았을 때 )
//	@ExceptionHandler(value = MethodArgumentNotValidException.class)
//	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
//		System.out.println("api 컨트롤러에서 처리 합니다~~");
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//	}

}
