package com.nutritrack2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritrack2.model.Food;
import com.nutritrack2.model.Serving;
import com.nutritrack2.service.FoodService;



@RestController
@RequestMapping("/nutritrack")
public class FoodRestController {

	@Autowired FoodService foodService;
	
	
	
	
	//Get all foods that contain in the repository.
	@GetMapping("/foods") 
	public List<Food> foods(){
		return foodService.getAllFoods();
	}
	
	//Get a food by its name. 
	@GetMapping("/foods/search")
	public List<Food> searchFoods(String name){
		List<Food> foods = foodService.findByName(name);
		return foods;
	}
	
	@GetMapping("/food/nutritions/{id}")
	public Serving getServings(@PathVariable String id ) {
		return foodService.getServings(id);
	}
	
}
