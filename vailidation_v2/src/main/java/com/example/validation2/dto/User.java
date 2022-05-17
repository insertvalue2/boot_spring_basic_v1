package com.example.validation2.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class User {

	@NotBlank(message = "이름을 입력해주세요")
	private String name;
	@Max(value = 90, message = "나이를 잘못 입력했습니다")
	@Min(value = 10, message = "나이를 잘못 입력했습니다")
	private int age;
	@Email
	private String email;
	// 	@Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",  message = "핸드폰 번호의 양식과 맞지 않습니다.")
	private String phoneNumber;
}
