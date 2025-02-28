package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.data.entity.UserEntity;
import com.gcu.service.RegistrationService;


/**
 * Controller class handling requests to /register endpoint.
 */
@Controller
public class RegistrationController {
	
	private final RegistrationService registrationService;
	
	/**
	 * Dependency injection through constructor
	 * @param registrationService Service handling user registration logic.
	 */
	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	/**
	 * GET method displaying registration form.
	 * @param model Model's attributes are used to render the view.
	 * @return Name of HTML file displaying registration form (newUser.html).
	 */
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new UserEntity());
		return "register/newUser";
	}
	
	/**
	 * POST method registering new user.
	 * @param user User entity containing registration details.
	 * @param model Model's attributes are used to render the view.
	 * @return Redirects to login page if registration is successful.
	 */
	@PostMapping("/register")
	public String registerUser(UserEntity user, Model model) {
		if (registrationService.registerUser(user))
			return "redirect:/login";
		model.addAttribute("error", "Username is already taken.");
		return "register/success";
	}
	
}
