package com.rating.app.exception;

public class RatingException extends Exception {

	private static final long serialVersionUID = 4630472082827765247L;

	private String message;

	public RatingException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
