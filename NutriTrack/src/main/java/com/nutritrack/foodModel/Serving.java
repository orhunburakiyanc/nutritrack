package com.nutritrack.foodModel;



public class Serving {
	
	private double calories;
	private double carbohydrate;
	private double protein;
	private double fat;
	private double sugar;
	private double trans_fat;
	private double saturated_fat;
	
	
	
	public Serving(double calories, double carbohydrate, double protein, double fat, double sugar, double trans_fat,
			double saturated_fat) {
		super();
		this.calories = calories;
		this.carbohydrate = carbohydrate;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.trans_fat = trans_fat;
		this.saturated_fat = saturated_fat;
	}
	
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public double getCarbohydrate() {
		return carbohydrate;
	}
	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	public double getTrans_fat() {
		return trans_fat;
	}
	public void setTrans_fat(double trans_fat) {
		this.trans_fat = trans_fat;
	}
	public double getSaturated_fat() {
		return saturated_fat;
	}
	public void setSaturated_fat(double saturated_fat) {
		this.saturated_fat = saturated_fat;
	}

	@Override
	public String toString() {
		return "Serving [calories=" + calories + ", carbohydrate=" + carbohydrate + ", protein=" + protein + ", fat="
				+ fat + ", sugar=" + sugar + ", trans_fat=" + trans_fat + ", saturated_fat=" + saturated_fat + "]";
	}
	
	
}
