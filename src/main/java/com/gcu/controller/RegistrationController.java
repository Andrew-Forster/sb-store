package com.gcu.controller;

import jakarta.validation.Valid;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gcu.model.RegistrationModel;
import com.gcu.service.RegistrationService;

@Controller
public class RegistrationController implements WebMvcConfigurer {

	private final RegistrationService registrationService;

	// Dependency injection through constructor
	public RegistrationController (RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	@Override
	public void addViewControllers(@NonNull ViewControllerRegistry registry) {
		registry.addViewController("/mainPage").setViewName("mainPage");
	}
	
	// GET request to display the registration page
	@GetMapping("/register")
	public String showRegistration(RegistrationModel registrationModel) {
		return "registrationPage";
	}

	// POST request to create a new user
	@PostMapping("/register")
	public String checkPersonInfo(@Valid RegistrationModel registrationModel, BindingResult bindingResult) {
		String username = registrationModel.getUsername();
		String email = registrationModel.getEmail();

		boolean validUsername;
		boolean validEmail;

		if (bindingResult.hasErrors()) {
			return "registrationPage";
		}

		validUsername = registrationService.validUsername(username);
		validEmail = registrationService.validEmail(email);

		if(!validUsername) {
			bindingResult.rejectValue("username", "error.user", "An account already exists with this username.");
		}
		else if(!validEmail) {
			bindingResult.rejectValue("email", "error.user", "An account already exists for this email.");
		}
		else {
			return "redirect:/login";
		}

		return "registrationPage";
	}
}
