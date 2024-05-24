package com.nutritrack2.model;

import java.time.LocalDateTime;

public class Token {

	private String token;
	private LocalDateTime timeOut;
	
	
	public Token() {
		// TODO Auto-generated constructor stub
	}


	public Token(String token, LocalDateTime timeOut) {
		super();
		this.token = token;
		this.timeOut = timeOut;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public LocalDateTime getTimeOut() {
		return timeOut;
	}


	public void setTimeOut(LocalDateTime timeOut) {
		this.timeOut = timeOut;
	}
	
	
	
	
}