package com.gcu.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepositoryInterface;
import com.gcu.model.ProductModel;
import jakarta.validation.Valid;

@Controller
public class ProductController {

	private final GamesRepositoryInterface gamesRepository;

	public ProductController(GamesRepositoryInterface gamesRepository) {
		this.gamesRepository = gamesRepository;
	}

	// GET request to display the product creation page
	@GetMapping("/product/create")
	public String productCreationDisplay(Model model) {
		model.addAttribute("product", new ProductModel());
		
		List<GameEntity> games = gamesRepository.findAll();
		model.addAttribute("games", games);
		
		return "products/productCreation";
	}

	// POST request to create a new product
	@PostMapping("/product/create")
	public String createProduct(@ModelAttribute @Valid ProductModel productModel,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "redirect:/product/create";
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

	@GetMapping("/product/edit/{id}")
	public String editProduct(@PathVariable Long id, Model model) {
		Optional<GameEntity> game = gamesRepository.findById(id);
		if (game.isPresent()) {
			model.addAttribute("game", game.get());
			return "products/productEdit";
		} else
			throw new IllegalArgumentException("Invalid product ID: " + id);
	}
	
	@PostMapping("/product/update")
	public String updateProduct(@ModelAttribute @Valid GameEntity game, 
								BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "products/productEdit";
		
		Optional<GameEntity> changeGame = gamesRepository.findById(game.getId());
		if (changeGame.isPresent()) {
			GameEntity updatedGame = changeGame.get();
			updatedGame.setName(game.getName());
			updatedGame.setPrice(game.getPrice());
			updatedGame.setCategory(game.getCategory());
			updatedGame.setDescription(game.getDescription());
			
			gamesRepository.save(updatedGame);
		} else
			throw new IllegalArgumentException("Invalid product ID: " + game.getId());
		
		return "redirect:/product/create";
	}
	
	@PostMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		Optional<GameEntity> game = gamesRepository.findById(id);
		if (game.isPresent()) {
			gamesRepository.deleteById(id);
		}
		
		else {
			throw new IllegalArgumentException("Invalid product ID: " + id);
		}
		return "redirect:/product/create";
	}

	@GetMapping("/product/details/{id}")
	public String productDetails(@PathVariable Long id, Model model) {
		Optional<GameEntity> game = gamesRepository.findById(id);
		if (game.isPresent()) {
			model.addAttribute("game", game.get());
			return "products/productDetails";
		} else
			throw new IllegalArgumentException("Invalid product ID: " + id);
	}
}
