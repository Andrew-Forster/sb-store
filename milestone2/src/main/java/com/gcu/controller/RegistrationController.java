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

@Controller
public class RegistrationController implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(@NonNull ViewControllerRegistry registry) {
		registry.addViewController("/mainPage").setViewName("mainPage");
	}

	@GetMapping("/register")
	public String showRegistration(RegistrationModel registrationModel) {
		return "registrationPage";
	}

	@PostMapping("/register")
	public String checkPersonInfo(@Valid RegistrationModel registrationModel, BindingResult bindingResult) {
		System.err.println(bindingResult.hasErrors());
		System.err.println(registrationModel);
		if (bindingResult.hasErrors()) {
			return "registrationPage";
		}

		return "redirect:/main";
	}
}
