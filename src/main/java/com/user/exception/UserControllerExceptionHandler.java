package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.user.domain.ErrorResponse;

@ControllerAdvice
public class UserControllerExceptionHandler {

	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<?> handleException(UserNotFoundException exception){
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
