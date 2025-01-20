package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.gcu.model.LoginModel;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return "loginPage";
	}

	@PostMapping("/login")
	public String submitLogin(@ModelAttribute LoginModel loginModel, Model model) {
		model.addAttribute("loginModel", loginModel);
    	return "redirect:/main";
	}
}
