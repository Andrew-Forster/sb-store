package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepository;
import com.gcu.model.ProductModel;
import jakarta.validation.Valid;

@Controller
public class ProductController {

	private final GamesRepository gamesRepository;

	public ProductController(GamesRepository gamesRepository) {
		this.gamesRepository = gamesRepository;
	}

	// GET request to display the product creation page
	@GetMapping("/product/create")
	public String productCreationDisplay(Model model) {
		model.addAttribute("product", new ProductModel());
		return "products/productCreation";
	}

	// POST request to create a new product
	@PostMapping("/product/create")
	public String createProduct(@ModelAttribute @Valid ProductModel productModel,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "products/productCreation";
		}
		GameEntity gameEntity = new GameEntity();
		gameEntity.setName(productModel.getName());
		gameEntity.setPrice(productModel.getPrice());
		gameEntity.setCategory(productModel.getCategory());
		gameEntity.setDescription(productModel.getDescription());
		gamesRepository.save(gameEntity);
		model.addAttribute("product", gameEntity);
		return "products/success";
	}

}
