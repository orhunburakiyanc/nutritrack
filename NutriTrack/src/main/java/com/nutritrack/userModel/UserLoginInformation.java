package com.nutritrack.userModel;

import java.util.Objects;

public class UserLoginInformation {

	
	private String email;
	private String password;
	private String phone_number;
	

	public UserLoginInformation(String email, String password, String phone_number) {
		super();
		this.email = email;
		this.password = password;
		this.phone_number = phone_number;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, password, phone_number);
	}

	
	
	
	
	
	
}
