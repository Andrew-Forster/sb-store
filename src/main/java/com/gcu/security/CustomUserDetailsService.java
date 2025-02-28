package com.gcu.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepositoryInterface;

/**
 * Service class for loading user details during authentication
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepositoryInterface userRepository;
	
	/**
	 * Dependency injection through constructor
	 * @param userRepository Interface for user data access
	 */
	public CustomUserDetailsService(UserRepositoryInterface userRepository) {
		this.userRepository = userRepository;
	}
	
	/**
	 * Method loading user by username
	 * @param username Username of the user attempting to login
	 * @return UserDetails containing user credentials and authority
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found."));
		return User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles(user.getRole()) 
				.build();
	}
}
