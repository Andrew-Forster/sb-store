package com.gcu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepositoryInterface;
import com.gcu.model.ProductModel;

@Controller
public class DisplayedProductsController {
	
	private final GamesRepositoryInterface gamesRepository;
	
	public DisplayedProductsController(GamesRepositoryInterface gamesRepository) {
		this.gamesRepository = gamesRepository;
	}
	
	@GetMapping("/displayedProducts")
	public String displayProducts(Model model) {
		model.addAttribute("game", new ProductModel());
		List<GameEntity> availableGames = gamesRepository.findAll();
		model.addAttribute("availableGames", availableGames);
		return "products/displayedProducts";
	}

}
