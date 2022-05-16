package ch01;

public class Encoder {
	
private IEncoder iEncoder; 
	
	// DI 의존 주입 
	public Encoder(IEncoder encoder) {
		this.iEncoder = encoder; 
	}
	
	public String encode(String message) {
		return iEncoder.encode(message);
	}
}
