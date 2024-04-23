package com.nutritrack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nutritrack.userModel.User;

import java.util.Optional;


public interface UserRepo extends MongoRepository<User,String>{
	
	public Optional<User> findById(String id);
	
}
