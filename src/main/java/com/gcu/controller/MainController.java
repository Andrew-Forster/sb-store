package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class handling requests to the /, /main, and /home endpoints.
 */
@Controller
public class MainController {

	/**
	 * GET method returning the main page.
	 * @return The name of HTML file displaying main page (mainPage.html).
	 */
	@GetMapping({ "/", "/main", "/home" })
	public String showTitle() {
		return "mainPage";
	}
}
