package com.example.validation3.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * @author ITPS
 *
 */
public class User {

	@NotBlank(message = "이름을 입력해주세요")
	private String name;

	@Max(value = 90, message = "나이를 잘못 입력했습니다")
	private int age;

	@Email // <-- 어노테이션 추가 하기
	private String email;

	private String phoneNumber;

	// part 2 --> 코드 추가하기
	@Size(min = 6, max = 6)
	private String reqYearMonth;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	@Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$")
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다.")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// 코드 추가 부분
	public String getReqYearMonth() {
		return reqYearMonth;
	}

	public void setReqYearMonth(String reqYearMonth) {
		this.reqYearMonth = reqYearMonth;
	}

	// 함수 생성하기 , @AssertTrue 사용하면 된다. @AssertTrue is 단어로 꼭 시작해야 한다.
	@AssertTrue(message = "yyyyMM  의 형식에 맞지 않습니다")
	public boolean isReqYearMonth() {

		try {
			// yyyyMMdd 까지 입력해야 된다.
			LocalDate date = LocalDate.parse(getReqYearMonth() + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", reqYearMonth=" + reqYearMonth + "]";
	}
}
