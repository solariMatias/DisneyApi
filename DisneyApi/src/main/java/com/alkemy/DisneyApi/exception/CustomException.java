package com.alkemy.DisneyApi.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9080071826329880080L;
	private HttpStatus status;
	private String message;

	public CustomException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
