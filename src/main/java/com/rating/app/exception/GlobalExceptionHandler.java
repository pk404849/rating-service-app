package com.rating.app.exception;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RatingException.class)
	public ResponseEntity<?> handleRatingException(RatingException ratingException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(ratingException.getMessage());
		errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setDateTime(new Timestamp(System.currentTimeMillis()));
		System.out.println("callng rating exception "+ratingException.getMessage());
		return ResponseEntity.ok(errorResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setDateTime(new Timestamp(System.currentTimeMillis()));
		System.out.println("callng global exception "+exception.getMessage());
		return ResponseEntity.ok(errorResponse);
	}
}
