package com.gcu.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerLoginService implements LoginInterface {
	
	@Override
	public boolean authenticate(String username, String password) {
		
		if ("customer".equals(username) && "password1".equals(password))
			return true;
		else
			return false;
	}

}
