package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.gcu.model.LoginModel;
import com.gcu.service.UserLoginService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping; 

@Controller
public class LoginController {

	// GET request to display the login page
	@GetMapping("/login")
	public String login() {
		return "loginPage";
	}

}
