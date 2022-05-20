package com.example.exception1.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> excption(Exception e) {
		System.out.println("========");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("========");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("잘못된 요청입니다.");
	}

	// 예외 클래스 마다 따르게 처리하고 싶다면 
	// MethodArgumentNotValidException (json 에서 argument를 보내지 않았을 때 )
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

}
