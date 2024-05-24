package com.nutritrack2.service;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nutritrack2.controller.FoodRestController;
import com.nutritrack2.model.Food;
import com.nutritrack2.model.Serving;
import com.nutritrack2.repository.UserRepo;
import com.nutritrack2.repository.FoodRepo;

import jakarta.annotation.PostConstruct;


@Service
public class FoodService {
	
	static final Logger logger = LoggerFactory.getLogger(FoodRestController.class);

	@Autowired FoodRepo foodRepository;
	@Autowired UserRepo userRepository;

	@PostConstruct
    public void init() {
		logger.info("Food Service is initializing...");
		if (foodRepository.count() == 0) {
			Serving serv1 = new Serving(110.0,0.0,23.09,1.24,0.0,0.025,0.33);// per 100g
			Food food1 = new Food("Chicken Breast","Meat",150.0);
			serv1 = calculateNutritionalValues(food1,serv1);
			food1.setFoodServings(serv1);
			
			
			Serving serv2 = new Serving(155.0,1.12,12.58,10.61,1.12,0.0,3.267);
			Food food2 = new Food("Boiled Egg","Egg",120.4);
			serv2 = calculateNutritionalValues(food2,serv2);
			food2.setFoodServings(serv2);
			
			Serving serv3 = new Serving(125.0,21.57,2.07,3.24,0.59,0.0,0.621);
			Food food3 = new Food("Rice","Legume Family",200.0);
			serv3 = calculateNutritionalValues(food3,serv3);
			food3.setFoodServings(serv3);
			
			Serving serv4 = new Serving(124.0,25.12,4.37,0.98,0.0,0.0,0.14);
			Food food4 = new Food("Pasta","Grain",125.4);
			serv4 = calculateNutritionalValues(food4,serv4);
			food4.setFoodServings(serv4);
			
			Serving serv5 = new Serving(50.0,4.71,3.29,2.0,5.16,0.0,1.215);
			Food food5 = new Food("Milk","Dairy Product",240.1);
			serv5 = calculateNutritionalValues(food5,serv5);
			food5.setFoodServings(serv5);
			
			Serving serv6 = new Serving(389.0,66.27,16.89,6.9,0.0,0.0,1.217);
			Food food6 = new Food("Oat","Cereal Grain",105.8);
			serv6 = calculateNutritionalValues(food6,serv6);
			food6.setFoodServings(serv6);
			
			foodRepository.save(food1);
			foodRepository.save(food2);
			foodRepository.save(food3);
			foodRepository.save(food4);
			foodRepository.save(food5);
			foodRepository.save(food6);
			
		}	
    }
	
	
	
	public List<Food> getAllFoods(){
		return foodRepository.findAll();
	}
	
	public List<Food> findByName(String name){
		return foodRepository.findByNameContainsIgnoreCase(name);
	}
	
	public Serving getServings(String id){
		Optional<Food> optionalFood = foodRepository.findById(id);
		Food foodTemp = optionalFood.get();
		return foodTemp.getFoodServings();
	}
	
	
	
	
	
	public Serving calculateNutritionalValues(Food food,Serving serving) {
		
		double foodWeight = food.getFoodWeight();
		
		double calories = serving.getCalories();
		double carbohydrate = serving.getCarbohydrate();
		double protein = serving.getProtein();
		double fat = serving.getFat();
		double sugar = serving.getSugar();
		double trans_fat = serving.getTrans_fat();
		double saturated_fat = serving.getSaturated_fat();
		
        // Calculate nutritional values based on 1 gram of food weight
        double factor = foodWeight / 100.0; // Convert food weight to a factor relative to 100 grams
        
        // Calculate nutritional values for the given food weight
        
        calories *= factor;
        carbohydrate *= factor;
        protein *= factor;
        fat *= factor;
        sugar *= factor;
        trans_fat *= factor;
        saturated_fat *= factor;
        
        serving.setCalories(calories);
        serving.setCarbohydrate(carbohydrate);
        serving.setProtein(protein);
        serving.setFat(fat);
        serving.setSugar(sugar);
        serving.setTrans_fat(trans_fat);
        serving.setSaturated_fat(saturated_fat);
        return serving;
    }
}
