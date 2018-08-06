package com.training.demo.restfulworks;

public class HelloWorld {
public HelloWorld() {
	// TODO Auto-generated constructor stub
}
	@Override
public String toString() {
	return "HelloWorld [message=" + message + "]";
}
	private String message;
	
	public HelloWorld(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
