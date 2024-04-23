package com.nutritrack.userModel;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.nutritrack.foodModel.Food;

@Document 
public class User {
	
	@Id private String id;
	
	private UserAttributes userAttribute;
	private UserLoginInformation userLogInfo;
	
	
	private double goalWeight;
	
	@DBRef
	private List<Food> personalized_List;
	
	@DBRef
	private Map<Date, List<Food>> datedMeal = new HashMap<>();
	
	
	
	
	public User(String id, UserAttributes userAttribute, UserLoginInformation userLogInfo, double goalWeight) {
		super();
		this.id = id;
		this.userAttribute = userAttribute;
		this.userLogInfo = userLogInfo;
		this.goalWeight = goalWeight;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public UserAttributes getUserAttribute() {
		return userAttribute;
	}




	public void setUserAttribute(UserAttributes userAttribute) {
		this.userAttribute = userAttribute;
	}




	public UserLoginInformation getUserLogInfo() {
		return userLogInfo;
	}




	public void setUserLogInfo(UserLoginInformation userLogInfo) {
		this.userLogInfo = userLogInfo;
	}




	public double getGoalWeight() {
		return goalWeight;
	}




	public void setGoalWeight(double goalWeight) {
		this.goalWeight = goalWeight;
	}




	public List<Food> getPersonalized_List() {
		return personalized_List;
	}




	public void setPersonalized_List(List<Food> personalized_List) {
		this.personalized_List = personalized_List;
	}




	public Map<Date, List<Food>> getDatedMeal() {
		return datedMeal;
	}




	public void setDatedMeal(Map<Date, List<Food>> datedMeal) {
		this.datedMeal = datedMeal;
	}
	
	
	
	
}
