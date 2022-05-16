package ch01;

public class MainTest {

	public static void main(String[] args) {
		String url = "www.naver.com/books/it?page=10?size=20&name=spring-boot";

		// base 64 encoding
		Base64Encoder encoder = new Base64Encoder();
		String result = encoder.encode(url);
		System.out.println(result);

		// url encoding
		UrlEncoder urlEncoder = new UrlEncoder();
		String urlResult = urlEncoder.encode(url);
		System.out.println(urlResult);

		// 인터페이스 활용 모습
		IEncoder base64Encoder = new Base64Encoder();
		String base64Result = base64Encoder.encode(url);
		System.out.println(base64Result);

		IEncoder urlEncoder2 = new UrlEncoder();
		String urlResult2 = urlEncoder.encode(url);
		System.out.println(urlResult2);

		// 조금더 진화 --> DI 개념을 추가
		// Encoder encoder = new Encoder(new Base64Encoder());
		Encoder encoder2 = new Encoder(new UrlEncoder());
		String result2 = encoder.encode(url);
		System.out.println(result2);

		// Encoder 객체에 주입 받을 객체를 추상화 한 후 실제 객체 생성시 사용할 객체를
		// 주입 받아서 동작을 처리하게 한다.

		// Encoder 라는 객체를 수정하지 않아도 Base64Encoder, UrlEncoder를 테스트해 볼 수 있다.

	}

}
