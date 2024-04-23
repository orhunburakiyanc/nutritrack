package com.nutritrack.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nutritrack.foodModel.Food;

public interface FoodRepo extends MongoRepository<Food,String>{
	
	public List<Food> findByNameContainsIgnoreCase(String name);


}
