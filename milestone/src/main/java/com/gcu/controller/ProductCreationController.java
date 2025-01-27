package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductCreationController {
	
	@GetMapping("/productCreation")
	public String productCreationDisplay() {
		return "productCreation";
	}

}
