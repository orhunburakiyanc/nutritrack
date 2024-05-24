package com.nutritrack2.model;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserAttributes {
	
	private int age;
	private Sex gender;
	
	private double height;
	private double weight;
	private LocalDate dateOfBirth;
	
	
	
	public UserAttributes() {
		super();
	}



	public UserAttributes(Sex gender, double height, double weight, String dateOfBirth) {
		super();
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.dateOfBirth = parseDate(dateOfBirth);
		this.age = calculateAge();
	}
	
	
	
	private LocalDate parseDate(String dateOfBirth) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(dateOfBirth, formatter);
	}

	
	public int calculateAge() {
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(dateOfBirth, currentDate);
		return period.getYears();
	}

	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	@Override
	public String toString() {
		return "UserAttributes [age=" + age + ", gender=" + gender + ", height=" + height + ", weight=" + weight
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
}
