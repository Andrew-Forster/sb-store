package com.gcu.service;

import org.springframework.stereotype.Service;

@Service
public class AdminLoginService implements LoginInterface {
	
	@Override
	public boolean authenticate(String username, String password) {
		
		if ("admin".equals(username) && "password2".equals(password))
			return true;
		else
			return false;
	}

}
