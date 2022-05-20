package com.example.exception2.advice;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception2.controller.ApiController;
import com.example.exception2.dto.MyError;

// ApiController.class 에서만 동작 
@RestControllerAdvice(basePackageClasses = ApiController.class)
public class ApiControllerAdvice {

	// 모든 예외를 처리
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		System.out.println(" >> 예외 발생 <<  ");
		System.out.println(e.getCause());
		System.out.println("[[ " + e.getClass() + " ]] ");
		System.out.println(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	//1. 파라미터 값이 누락일 때 사용하는 예외처리
	// (get : MissingServletRequestParameterException ) 
	// (post : MethodArgumentNotValidException )
	

	// GET 방식일 때 요청 파라미터값 누락일 때 예외 발생
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		System.out.println("missingServletRequestParameterException 실행");
		// 둘다 안들어 왔을 경우 처음부터
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		System.out.println(fieldName);
		System.out.println(fieldType);
		System.out.println(invalidValue);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + " 을 입력 해야 합니다");
	}
	
	// POST 방식일 때 요청 파라미터값 누락일 때 예외 발생
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request1) {
		System.out.println("MethodArgumentNotValidException 메서드 호출");
		// post 방식은 동시에 처리 가능 
		List<MyError> errorList = new ArrayList<>();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	
	//2. 넘어온 인자값이 잘못 되었을 때 (@Valid 와 활용) 
	// get : ConstraintViolationException
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e) {
		System.out.println("ConstraintViolationException 메서드 호출");

		List<MyError> errorList = new ArrayList<>();

		e.getConstraintViolations().forEach(error -> {
			String str_field = error.getPropertyPath().toString();
			int index = str_field.indexOf(".");
			String field = str_field.substring(index + 1);
			String messge = error.getMessage();
			String invalidValue = error.getInvalidValue().toString();

			System.out.println(field);
			System.out.println(messge);
			System.out.println(invalidValue);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("222");
	}
	
	
	

	

}
