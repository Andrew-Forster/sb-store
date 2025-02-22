package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 

@Controller
public class LoginController {

	// GET request to display the login page
	@GetMapping("/login")
	public String login() {
		return "loginPage";
	}

}
