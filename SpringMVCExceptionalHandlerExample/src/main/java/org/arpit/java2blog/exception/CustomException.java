package org.arpit.java2blog.exception;

public class CustomException extends Exception{
	
	String message;

	public CustomException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	};
	
}
