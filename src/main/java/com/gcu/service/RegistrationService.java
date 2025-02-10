package com.gcu.service;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements RegistrationInterface {

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
