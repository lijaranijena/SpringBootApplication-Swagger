package com.user.domain;

import java.time.LocalDateTime;

import lombok.Getter;

import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponse {
	private LocalDateTime time;
	private HttpStatus statusCode;
	private String errorMessage;
	public ErrorResponse(HttpStatus statusCode, String errorMessage) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.time=LocalDateTime.now();
	}
	

}
