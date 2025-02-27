package com.gcu.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Class implementing UserDetails interface and representing an authenticated user
 */
public class CustomUserDetails implements UserDetails {
	
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	/**
	 * Parameterized constructor
	 * @param user User object containing username and password
	 * @param roles List of user's authorities
	 */
	public CustomUserDetails(User user, List<String> roles) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.authorities = roles.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role))
				.collect(Collectors.toList());
	}
	
	/**
	 * Method retrieving list of user's authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	/**
	 * Method retrieving user's password
	 */
	@Override
	public String getPassword() {
		return password;
	}
	
	/**
	 * Method retrieving user's username
	 */
	@Override
	public String getUsername() {
		return username;
	}
	
	/**
	 * Method checking if account is not expired
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	/**
	 * Method checking if the account is not locked
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	/**
	 * Method checking if the credentials are not expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	/**
	 * Method checking if the user's account is enabled.
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
