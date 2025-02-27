package com.gcu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepositoryInterface;
import com.gcu.model.ProductModel;

/**
 * Controller class handling requests to the /displayedProducts endpoint.
 */
@Controller
public class DisplayedProductsController {
	
	private final GamesRepositoryInterface gamesRepository;
	
	/**
	 * Dependency injection through constructor
	 * @param gamesRepository The repository used to retrieve game data.
	 */
	public DisplayedProductsController(GamesRepositoryInterface gamesRepository) {
		this.gamesRepository = gamesRepository;
	}
	
	/**
	 * Method retrieving the list of available games from the repository and adding them to the model.
	 * @param model Model's attributes are used to render the view.
	 * @return The name of HTML file displaying products (displayedProducts.html).
	 */
	@GetMapping("/displayedProducts")
	public String displayProducts(Model model) {
		model.addAttribute("game", new ProductModel());
		List<GameEntity> availableGames = gamesRepository.findAll();
		model.addAttribute("availableGames", availableGames);
		return "products/displayedProducts";
	}

}