package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.gcu.model.LoginModel;
import com.gcu.service.CustomerLoginService;
import com.gcu.service.AdminLoginService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
	
	
	private final AdminLoginService adminLoginService;
	private final CustomerLoginService customerLoginService;
	
	// Dependency injection through constructor
	public LoginController(AdminLoginService adminLoginService,
						   CustomerLoginService customerLoginService) {
		this.adminLoginService = adminLoginService;
		this.customerLoginService = customerLoginService;
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return "loginPage";
	}

	@PostMapping("/login")
	public String submitLogin(@ModelAttribute LoginModel loginModel, Model model) {
		
		String username = loginModel.getUsername();
		String password = loginModel.getPassword();
		
		boolean authenticated;
		
		if ("admin".equals(username)) {
			authenticated = adminLoginService.authenticate(username, password);
			if (authenticated)
				return "redirect:/productCreation";
			else
				model.addAttribute("error", "Invalid username or password");
		} else if ("customer".equals(username)) {
			authenticated = customerLoginService.authenticate(username, password);
			if (authenticated)
				return "redirect:/displayedProducts";
			else
				model.addAttribute("error", "Invalid username or password");
		} else 
			model.addAttribute("error", "Invalid username or password");
		
		return "loginPage";
			
	}
}
