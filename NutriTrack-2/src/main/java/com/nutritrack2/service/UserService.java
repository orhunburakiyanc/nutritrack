package com.nutritrack2.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nutritrack2.controller.UserException;
import com.nutritrack2.model.Food;
import com.nutritrack2.model.Sex;
import com.nutritrack2.model.Token;
import com.nutritrack2.model.User;
import com.nutritrack2.model.UserAttributes;
import com.nutritrack2.repository.FoodRepo;
import com.nutritrack2.repository.UserRepo;

import jakarta.annotation.PostConstruct;


@Service
public class UserService {
	@Autowired UserRepo userRepo;
	@Autowired FoodRepo foodRepo;
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	@PostConstruct
	public void init() {
		
		
		List<Food> foodList = foodRepo.findAll();
		if(userRepo.count() == 0) {
			// Initialize user 1
	        UserAttributes userAttribute1 = new UserAttributes(Sex.MALE, 1.83, 74.4, "2003-03-29");
	        User user1 = new User("jake_324_p@email.com", "@93824", "Jake","Paul");
	        user1.setUserAttribute(userAttribute1);
	        List<Food> personalizedList1 = new ArrayList<>();
	       
	        personalizedList1.add(foodList.get(0));
	        personalizedList1.add(foodList.get(1));
	        user1.setPersonalized_List(personalizedList1);
	        
	        
	        
	        //Initialize user 2
	        UserAttributes userAttribute2 = new UserAttributes(Sex.FEMALE, 1.69, 64.4, "2001-01-19");
	        User user2 = new User("auggie_532@email.com", "@45524", "Auggie","Pyscho");
	        user2.setUserAttribute(userAttribute2);
	        List<Food> personalizedList2 = new ArrayList<>();
	        
	        personalizedList2.add(foodList.get(3));
	        personalizedList2.add(foodList.get(4));
	        user2.setPersonalized_List(personalizedList2);
	 
	        userRepo.save(user1);
	        userRepo.save(user2);
	        
		}
	
        
	}
	
	//There is no need to check user if it exist in the repo due to this function will
	//implied after the sign-up or login functionalities.
	public void addUserAttributes(UserAttributes userAttribute, String id) {
		
		Optional<User> user = userRepo.findById(id);	
		user.get().setUserAttribute(userAttribute);
		userRepo.save(user.get());
		
	}
	public UserAttributes getUserAttributes(String id) {
		Optional<User> user = userRepo.findById(id);
		return user.get().getUserAttribute();
		
		
	}
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public List<Food> getPersonalizedList(String id){
		Optional<User> user = userRepo.findById(id);
		return user.get().getPersonalized_List();
		
	}
	
	/*public void addFoodToPersonalizedList(String foodName, String userId) {
		
		Optional<User> optionalUser = userRepo.findById(userId);
		if (optionalUser.isPresent()) {
			List<Food> food = foodRepo.findByName(foodName);
			User user = optionalUser.get();
			
			logger.info(food.getName());
			
			user.getPersonalized_List().add(food[0]);
			userRepo.save(user); // Save the user with the updated personalized list
		}else {
			// Handle the case where the user is not found
            // For example, you can log an error
            System.err.println("User with ID " + userId + " not found");
		}
		
		
		if (optionalUser.isPresent() && optionalFood.isPresent()) {
	        Food food = optionalFood.get();
	        
	        List<Food> pList = optionalUser.get().getPersonalized_List();
	        pList.add(food);
	        
	        optionalUser.get().setPersonalized_List(pList);
	        
	        userRepo.save(optionalUser.get()); // Save the user with the updated personalized list
	    } else {
	        // If either the user or the food is not found, log an error or throw an exception
	        if (!optionalUser.isPresent()) {
	            // Handle the case where the user is not found
	            // For example, you can log an error
	            System.err.println("User with ID " + userId + " not found");
	        }
	        if (!optionalFood.isPresent()) {
	            // Handle the case where the food is not found
	            // For example, you can log an error
	            System.err.println("Food with ID " + foodId + " not found");
	        }
	        // You can also throw an exception or return an error response here
	    }
	}*/
		
		
	
	
	
	
	
	
//User login-register-logout functionalities.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public User loginUser(User user) throws Exception{
		User userFound = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		if(userFound==null) {
			throw new UserException("Username or password is wrong.");
		}
		
		String tokenText = new ObjectId().toString();
		Token token = new Token(tokenText,LocalDateTime.now().plusDays(100));
		userFound.setToken(token);
		userFound = userRepo.save(userFound);

		return userFound;
		
	}
	
	
	public boolean registerUser(User user) throws Exception {
		
		try {
			userRepo.save(user);
		} catch (org.springframework.dao.DuplicateKeyException e) {
			throw new UserException("Username already exists.");
		}catch (Exception e) {
			throw e;
		}
		
		return true;
	}
	
	public User getUserByToken(String tokenStr) {
		User userFound = userRepo.findByTokenString(tokenStr);
		return userFound;
		
	}
	
	public void destroyToken(String tokenStr) {
		User userFound = userRepo.findByTokenString(tokenStr);
		
		userFound.setToken(null);
		
		userRepo.save(userFound);
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	
	
}