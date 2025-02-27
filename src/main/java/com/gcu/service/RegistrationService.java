package com.gcu.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepositoryInterface;

/**
 * Service class handling user registration business logic
 */
@Service
public class RegistrationService {
	
	private final UserRepositoryInterface userRepository;
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * Dependency injection through constructor
	 * @param userRepository Repository interface performing CRUD operations on UserEntity
	 * @param passwordEncoder Password encoder to securely store user's password
	 */
	public RegistrationService(UserRepositoryInterface userRepository,
							   PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	/**
	 * Method registering new user
	 * @param user UserEntity object containing details of the user
	 * @return true if registration is successful, false if the username is already taken
	 */
	public boolean registerUser(UserEntity user) {
		if (userRepository.findByUsername(user.getUsername()).isPresent())
			return false;
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("CUSTOMER");
		userRepository.save(user);
		
		return true;
	}
    
}
