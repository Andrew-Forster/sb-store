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

	private final UserLoginService userLoginService;

	// Dependency injection through constructor
	public LoginController(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	// GET request to display the login page
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return "loginPage";
	}

	// POST request to authenticate the user
    @PostMapping("/login")
    public String submitLogin(@ModelAttribute LoginModel loginModel, Model model) {
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();

        boolean authenticated = userLoginService.authenticate(username, password);

        if (authenticated) {
            return "redirect:/product/create";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "loginPage";
        }
    }
}
