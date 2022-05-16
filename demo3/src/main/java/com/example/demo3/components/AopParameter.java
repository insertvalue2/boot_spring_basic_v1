package com.example.demo3.components;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopParameter {

	// 포인트 컷 (대표적인 부분 확인)
	// role 설정 ( 하위에 있는 부분에 모든 메소드를 다 aop로 보겠다
	@Pointcut("execution(* com.example.demo3.controller..*.*(..))")
	private void cut() {
	}

	// cut() 메서드가 실행 되는 지점 이전에 before() 메서드 실행
	@Before("cut()")
	public void before(JoinPoint joinPoint) {

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		System.out.println("사용된 method 방식 확인");
		System.out.println("method : " + method.getName());

		// 메서드에 들어가는 매개변수 배열을 읽어옴
		Object[] args = joinPoint.getArgs();

		// 매개변수 배열의 종류와 값을 출력
		for (Object obj : args) {
			System.out.println("type : " + obj.getClass().getSimpleName());
			System.out.println("value : " + obj);
		}
	}

	// cut() 메서드가 종료되는 시점에 afterReturn() 메서드 실행
	// @AfterReturning 어노테이션의 returning 값과 afterReturn 매개변수 obj의 이름이 같아야 함
	@AfterReturning(value = "cut()", returning = "obj")
	public void afterReturn(JoinPoint joinPoint, Object obj) {
		System.out.println("=================");
		System.out.println("return obj");
		System.out.println(obj);
	}

}
