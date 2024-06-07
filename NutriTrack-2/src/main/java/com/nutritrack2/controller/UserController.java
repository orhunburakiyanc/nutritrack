package com.nutritrack2.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutritrack2.model.Food;
import com.nutritrack2.model.Token;
import com.nutritrack2.model.User;
import com.nutritrack2.model.UserAttributes;
import com.nutritrack2.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired private UserService userService;
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	
	@PutMapping("/updateattributes/{id}") 
	public void addUserAttributes(@RequestBody UserAttributes userAttributes, @PathVariable String id) {
		userService.addUserAttributes(userAttributes, id);
	}
	
	@GetMapping("/getattributes/{id}")
	public UserAttributes getUserAttributes(@PathVariable String id) {
		return userService.getUserAttributes(id);
	}
	
	
	@GetMapping("/personalizedList/{id}")
	public List<Food> getPersonalizedList(@PathVariable String id){
		return userService.getPersonalizedList(id);
	}
	
	@GetMapping("/getUserByEmail/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	@PutMapping("/updatePersonalizedList/{id}")
	public void updateUserPersonalizedList(@RequestBody List<Food> personalizedList, @PathVariable String id) {
		userService.updateUserPersonalizedList(personalizedList, id);
	}
	
	
	
	@PostMapping("/login")
	public Payload<Token> loginUser(@RequestBody User user){
		
		try {
			user = userService.loginUser(user);
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		
		return new Payload<Token>(LocalDateTime.now(),"OK",user.getToken());
		
	}
	
	
	@GetMapping("/logout")
	public Payload<String> logoutUser(@RequestHeader String token){

		userService.destroyToken(token);
		
		
		return new Payload<String>(LocalDateTime.now(),"OK","Token destroyed.");
		
	}
	
	@PostMapping("/register")
	public Payload<String> registerUser(@RequestBody User user) throws UserException{
		
		if(user.getEmail()==null ||  
				user.getPassword()==null || 
				user.getName()==null || 
				user.getLastName() ==null) {
			logger.error("User field problem");
			throw new UserException("All fields are required.");
		}
		
		try {
			userService.registerUser(user);
		} catch (Exception e) {
			logger.error(e.getMessage());
		
			throw new UserException(e.getMessage());
		}
		
		return new Payload<String>(LocalDateTime.now(),"OK", "User registered.");
		
		
	}
	
	@GetMapping("/getall")
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}
	
	
	
}
