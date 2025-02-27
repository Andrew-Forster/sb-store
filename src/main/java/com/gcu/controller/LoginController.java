package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 

/**
 * Controller class handling requests to the /login endpoint.
 */
@Controller
public class LoginController {

	/**
	 * GET method returning login page.
	 * @return The name of HTML file displaying login page (loginPage.html).
	 */
	@GetMapping("/login")
	public String login() {
		return "loginPage";
	}

}
