package com.nutritrack.userModel;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class UserAttributes {
	
	private String name;
	private int age;
	private Sex gender;
	
	private double height;
	private double weight;
	private Date dateofbirth;
	
	public UserAttributes(String name, Sex gender, double height, double weight, Date dateofbirth) {
		super();
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.dateofbirth = dateofbirth;
	}
	
	
	public int getAge() {
		LocalDate birthLocalDate = dateofbirth.toLocalDate();
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(birthLocalDate, currentDate);
		this.age = period.getYears();
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	
}
