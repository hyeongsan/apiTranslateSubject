package com.cos.apiTranslateSubject.handler.ex;

public class CustomApiException extends RuntimeException{

	private static final long serialVersionUID = -807520916259076805L;

	public CustomApiException(String message) {
		super(message);
	}
	
}
