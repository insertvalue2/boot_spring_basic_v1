package com.example.demo2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.dto.User;

/**
 * @author ITPS
 * Response 와 MIME TYPE 에 이해 및 실습
 * 
 * https://devnote1.tistory.com/5?category=1047901
 */
@RestController
@RequestMapping("/api")
public class APIController {
	
	// 1 
	// 응답 HTTP 메세지에 text/plan 
	/**
	 * @param account
	 * 여기서는 리턴값이 String이다. !  
	 * 요청 값으로 @RequestParam인 account 안들어 오면 
	 * 400 에러 !!! 
	 * @return
	 */
	@GetMapping("/text")
	public String text(@RequestParam String account) {
//		account = "text";
		return account; 
	}

	
	// 2 
	// 응답 HTTP 메세지에 application/json 
	@PostMapping("/json")
	public User json(@RequestBody  User user) {
		System.out.println("server console");
		System.out.println(user.getName());
		return user; 
	}
	
	// ResponseEntity 사용방법 
	// 202 , 200 --> 응답을 돌려 줄때 응답 코드를 지정해서 줄 수 있다. 
	// 명확하게 status 코드 지정해서 돌려 주는것이 좋다. (권장사항) 
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user) {
		// ResponseEntity status, header 등을 설정할 수 있다. 
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	// dto null 값 제거 하기 
	// @JsonInclude(JsonInclude.Include.NON_NULL)
}




