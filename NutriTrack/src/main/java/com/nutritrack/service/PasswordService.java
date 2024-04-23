package com.nutritrack.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class PasswordService {
	
	
	public static String hashPassword(String password) {
        // Hash the password using BCrypt
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verifyPassword(String inputPassword, String hashedPassword) {
        // Verify the input password against the hashed password
        return BCrypt.checkpw(inputPassword, hashedPassword);
        
        
    }
    
       
}
