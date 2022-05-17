학습목표 

AOP 개념 

스프링 어플리케이션은 대부분 특별한 경우를 제외 하고는
 MVC 웹 어플리케이션에서는 
Web Layer,
Business Layer,
Data Layer 로 정의 되어 있다.



Web Layer : Rest API를 제공하며, Client 중심의 로직 적용
Business Layer : 내부 정책에 따른 logic를 개발하며, 주로 해당 부분을 개발
Data Layer : 데이터 베이스 및 외부와의 연동 처리

핵심로직 + 공통로직으로 분리할 수 있다. 



