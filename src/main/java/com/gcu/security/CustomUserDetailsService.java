package com.gcu.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepositoryInterface;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepositoryInterface userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public CustomUserDetailsService(UserRepositoryInterface userRepository,
								    PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found."));
		return User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles("USER")
				.build();
	}
}
