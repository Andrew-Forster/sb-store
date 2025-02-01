package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayedProductsController {
	
	@GetMapping("/displayedProducts")
	public String displayProducts() {
		return "displayedProducts";
	}

}
