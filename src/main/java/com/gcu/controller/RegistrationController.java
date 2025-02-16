package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.data.entity.UserEntity;
import com.gcu.service.RegistrationService;


@Controller
public class RegistrationController {
	
	private final RegistrationService registrationService;
	
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new UserEntity());
		return "register/newUser";
	}
	
	@PostMapping("/register")
	public String registerUser(UserEntity user, Model model) {
		if (registrationService.registerUser(user))
			return "redirect:/login";
		model.addAttribute("error", "Username is already taken.");
		return "register/success";
	}
	
}
