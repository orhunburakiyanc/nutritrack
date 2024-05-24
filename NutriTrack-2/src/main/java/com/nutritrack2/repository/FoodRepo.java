package com.nutritrack2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nutritrack2.model.Food;

@Repository
public interface FoodRepo extends MongoRepository<Food,String>{
	
	public List<Food> findByNameContainsIgnoreCase(String name);
	
	public List<Food> findByName(String name);
	
	public Optional<Food> findById(String id);
	
}
