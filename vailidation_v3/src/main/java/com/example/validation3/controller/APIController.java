package com.example.validation3.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation3.dto.User;

@RestController
@RequestMapping("/api")
public class APIController {

	// 실습 1 예전 방식으로 사용
	@PostMapping("/user1")
	public ResponseEntity<User> user(@RequestBody User user) {
		// 예전 방식
		if (user.getAge() < 1 || user.getAge() > 100) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		System.out.println(user);
		return ResponseEntity.ok(user);
	}

	// 실습 2 Dto 에 어노테이션 활용
	// 라이브러리 추가 하기 !!
	// 반드시 @Valid 어노테이션을 추가해야 된다.
	// 리빌드 추천 (서버 재시작)
	@PostMapping("/user2")
	public ResponseEntity<User> user2(@Valid @RequestBody User user) {
		System.out.println("check !!! ");
		// 예전 방식
		if (user.getAge() < 1 || user.getAge() > 100) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
		}
		System.out.println(user);
		return ResponseEntity.ok(user);
	}

	// 실습 3
	// User 클래스에 핸드폰번호 정규식 추가해보기

	// 실습 4
	// BindingResult 에 대해 알아 보자
	@PostMapping("/user3")
	public ResponseEntity user3(@Valid @RequestBody User user, BindingResult bindingResult) {

		StringBuilder sb = new StringBuilder();
		// bindingResult 가 @Valid 대한 결과값을 가지고 있다.
		if (bindingResult.hasErrors()) {

			bindingResult.getAllErrors().forEach(error -> {
				FieldError field = (FieldError) error;
				String message = field.getDefaultMessage();

				System.out.println("field : " + field.getField());
				System.out.println("message : " + message);

				sb.append("field : " + field.getField());
				sb.append("message : " + message);
			});

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
		}

		return ResponseEntity.ok(user);
	}

}