package com.gcu.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepositoryInterface;

@Service
public class RegistrationService implements RegistrationInterface {
	
	private final UserRepositoryInterface userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public RegistrationService(UserRepositoryInterface userRepository,
							   PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public boolean registerUser(UserEntity user) {
		if (userRepository.findByUsername(user.getUsername()).isPresent())
			return false;
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
		return true;
	}

	@Override
	public boolean validUsername(String username) {
		// Will pull from DB to validate once DB is set up.
		if ("customer".equals(username) || "admin".equals(username)) {
            return false;
        }
        else {
            return true;
        }
	}

	@Override
	public boolean validEmail(String email) {
		// Will pull from DB to validate once DB is set up.
		if ("test@test.com".equals(email)) {
            return false;
        }
        else {
            return true;
        }
	}
    
}
