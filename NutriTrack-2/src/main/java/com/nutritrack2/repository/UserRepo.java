package com.nutritrack2.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nutritrack2.model.User;


public interface UserRepo extends MongoRepository<User,String> {

	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email,String password);
	@Query("{'token.token':?0}")
	public User findByTokenString(String tokenStr);
	
	public Optional<User> findById(String id);

	
}