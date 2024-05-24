package com.nutritrack2.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

	
	
	@ExceptionHandler(UserException.class)
	public Payload<String> handleRegisterException(UserException ex) {
		
		return new Payload<String>(LocalDateTime.now(), "ERROR",ex.getMessage());
		
		
	}
	
	
}