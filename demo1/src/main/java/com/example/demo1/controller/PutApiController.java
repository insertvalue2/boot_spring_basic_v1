package com.example.demo1.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.PostRequestDto;
import com.example.demo1.model.PutRequestDto;

@RestController
@RequestMapping("/api")
public class PutApiController {
	
	@PutMapping("/put")
	public PostRequestDto put(@RequestBody PostRequestDto requestDto) {
		System.out.println(requestDto.toString());
		return requestDto;
	}
	
	
	// PutRequestDto  설계 후 확인 
	@PutMapping("/put2")
	public PutRequestDto put2(@RequestBody PutRequestDto requestDto) {
		System.out.println(requestDto.toString());
		return requestDto;
	}
	
}
