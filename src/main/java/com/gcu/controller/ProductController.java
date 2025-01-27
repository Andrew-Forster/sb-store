package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.ProductModel;

import jakarta.validation.Valid;

@Controller
public class ProductController {

	// GET request to display the product creation page
	@GetMapping("/product/create")
	public String productCreationDisplay(Model model) {
		model.addAttribute("product", new ProductModel());
		return "products/productCreation";
	}
	
	// POST request to create a new product
	@PostMapping("/product/create")
	public String createProduct(@Valid ProductModel product, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "products/productCreation";
		}
		model.addAttribute("product", product);
		return "products/success";
	}

}
