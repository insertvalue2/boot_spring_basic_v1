package com.example.demo1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.PostRequestDto;

@RestController
@RequestMapping("/api")
public class PostController {
	
	// Map 방식에 이용 (개발자는 어떤 값을 보내질 알고 있다) 
	//http://localhost:8080/api/post
	@PostMapping("/post1")
	public void post1(@RequestBody Map<String, Object> requestData) {
		requestData.entrySet().forEach(entry ->  {
			System.out.println("key : " + entry.getKey());
			System.out.println("key : " + entry.getValue());
		});
	}
	
	
	// Dto 방식으로 변경 
	// 응답 처리해보기 
	@PostMapping("/post2")
	public String  post2(@RequestBody PostRequestDto requestData) {
		
		return requestData.toString();
	}
	
}



