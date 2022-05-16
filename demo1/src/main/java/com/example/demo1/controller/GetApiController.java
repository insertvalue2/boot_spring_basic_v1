package com.example.demo1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.model.UserRequest;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

	// http://localhost:8080/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "say hello";
	}

	// path-variable 방식 
	
	// http://localhost:8080/api/get/path-variable/xxx
	@GetMapping(path = "/path-variable/{name}")
	public String queryParam(@PathVariable(name = "name") String name) {
		System.out.println("브라우저에 들어온 값을 받음 : " + name);
		return "[[" + name + "]]";
	}

	// http://localhost:8080/api/get/path-variable/[name]/[age]
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam2(@PathVariable(name = "name") String name, @PathVariable(name = "age") int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		return "name : " + name + ", age : " + age;
	}
	
	
	// query parameter  방식
	
	// http://localhost:8080/api/get/query-param1?name=홍길동&email=ste@naver.com&age=11&birth=1990
	// 보낼때 --> 더 추가 하는것은 상관이 없다. 
	// 받을때 --> 매개 변수에 선언한 값이 없이 보내게 된다면 Error Page(error)
	// age(int) 에 문자열을 넣으면 400에러가 발생 !
	// 요소가 너무 많아지면 번거럽고 가독성과 실수 발생이 높음 ===> Map -> dto 방식으로 변환 추천  
	@GetMapping("query-param1")
	public String queryParam1(@RequestParam String name,
			@RequestParam int age, 
			@RequestParam String email) {
		
		return "name :" + name + "age : " + age + "email : " + email;
	}
	
	
	// Map 활용 방식
	//http://localhost:8080/api/get/query-param2?name=홍길동&email=ste@naver.com&age=11&birth=1990
	@GetMapping("query-param2")
	public String queryParam2(@RequestParam Map<String, String> data) {
		
		StringBuilder sb = new StringBuilder();
		
		data.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println();
			sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
		});
		return sb.toString();
	}
	
	
	
	// Dto 활용 방식
	// MessageConverter 가 알아서 처리해준다. (사실 위 사항 전부)
	// @RequestParam 붙이지 말아야 한다.
	// dto 에 속성값이 없으면 파싱을 하지 않는다. 
	// dto에 속성이 선언되어 있지만 요청받는 값이 키(속성이 없으면) 무시 한다(기본값으로 초기화 됨)
	//http://localhost:8080/api/get/query-param3?name=홍길동&email=ste@naver.com&age=11&birth=1990
	@GetMapping("query-param3")
	public String queryParam3(UserRequest userDto) {
		return userDto.toString();
	}
	
}
