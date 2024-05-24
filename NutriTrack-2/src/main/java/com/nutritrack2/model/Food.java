package com.nutritrack2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Food {

	@Id private String id;
	
	private String name;
	private String type;
	private Serving foodServings;
	private double foodWeight;
	
	public Food() {
		
	}
	
	public Food(Serving foodServings) {
		super();
		this.foodServings = foodServings;
	}
	
	
	public Food(String name, String type, double foodWeight) {
		super();
		this.name = name;
		this.type = type;
		this.foodWeight = foodWeight;
	}
	
	public Food(String id, String name, String type, double foodWeight) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.foodWeight = foodWeight;
	}
	
	
	public Food(String name, String type, double foodWeight, Serving foodServings) {
		super();
		this.name = name;
		this.type = type;
		this.foodWeight = foodWeight;
		this.foodServings = foodServings;
	}


	public Food(String id, String name, String type, double foodWeight, Serving foodServings) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.foodWeight = foodWeight;
		this.foodServings = foodServings;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getFoodWeight() {
		return foodWeight;
	}


	public void setFoodWeight(double foodWeight) {
		this.foodWeight = foodWeight;
	}


	public Serving getFoodServings() {
		return foodServings;
	}


	public void setFoodServings(Serving foodServings) {
		this.foodServings = foodServings;
	}


	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", type=" + type + ", foodWeight=" + foodWeight + ", foodServings="
				+ foodServings + "]";
	}
	
	
}
