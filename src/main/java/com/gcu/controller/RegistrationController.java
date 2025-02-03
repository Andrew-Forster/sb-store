package com.gcu.controller;

import jakarta.validation.Valid;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gcu.data.entity.UserEntity;
import com.gcu.model.RegistrationModel;
import com.gcu.service.RegistrationService;
import com.gcu.data.repository.UserRepositoryInterface;


@Controller
public class RegistrationController implements WebMvcConfigurer {

	private final RegistrationService registrationService;

	private final UserRepositoryInterface userRepository;
	
	// Dependency injection through constructor
	public RegistrationController (RegistrationService registrationService, UserRepositoryInterface userRepository) {
		this.registrationService = registrationService;
		this.userRepository = userRepository;
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


	@PostMapping("/register")
	public String createUser(@ModelAttribute @Valid RegistrationModel registrationModel, 
							    BindingResult bindingResult, 
							    Model model) {
		
		String username = registrationModel.getUsername();
		String email = registrationModel.getEmail();

		int validUsername;
		int validEmail;
	
		validUsername = userRepository.validUsername(username);
		validEmail = userRepository.validEmail(email);

		if(validUsername > 0) {
			bindingResult.rejectValue("username", "error.user", "An account already exists with this username.");
		}
		else if(validEmail > 0) {
			bindingResult.rejectValue("email", "error.user", "An account already exists for this email.");
		}
		else if (bindingResult.hasErrors()) {
			return "register/newUser";
		}
		else {
			UserEntity userEntity = new UserEntity();
			userEntity.setUsername(registrationModel.getUsername());
			userEntity.setPassword(registrationModel.getPassword());
			userEntity.setFirstName(registrationModel.getFirstName());
			userEntity.setLastName(registrationModel.getLastName());
			userEntity.setEmail(registrationModel.getEmail());
			userEntity.setPhoneNumber(registrationModel.getPhoneNumber());
			userRepository.save(userEntity);
			model.addAttribute("user", userEntity);
			return "register/success";
		}
		return "register/newUser";
	}
}
