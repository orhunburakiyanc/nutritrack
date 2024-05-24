package com.nutritrack2.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String email;
	private String password;
	private Token token;
	private String name;
	private String lastName;

	private List<Food> personalized_List;
	private UserAttributes userAttribute;
	private double goalWeight;
	

	public User() {
		// TODO Auto-generated constructor stub
		userAttribute = new UserAttributes();
		personalized_List = new ArrayList<Food>();
	}

	
	public User(String email, String password, String name, String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
	}


	public User(String email, String password, Token token, String name, String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.token = token;
		this.name = name;
		this.lastName = lastName;
	}

	
	
	public User(List<Food> personalized_List, UserAttributes userAttribute, double goalWeight) {
		super();
		this.personalized_List = personalized_List;
		this.userAttribute = userAttribute;
		this.goalWeight = goalWeight;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public Token getToken() {
		return token;
	}


	public void setToken(Token token) {
		this.token = token;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public List<Food> getPersonalized_List() {
		return personalized_List;
	}



	public void setPersonalized_List(List<Food> personalized_List) {
		this.personalized_List = personalized_List;
	}



	public UserAttributes getUserAttribute() {
		return userAttribute;
	}



	public void setUserAttribute(UserAttributes userAttribute) {
		this.userAttribute = userAttribute;
	}



	public double getGoalWeight() {
		return goalWeight;
	}



	public void setGoalWeight(double goalWeight) {
		this.goalWeight = goalWeight;
	}

	
	
	
	
}




