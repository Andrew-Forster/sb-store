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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepositoryInterface;
import com.gcu.model.ProductModel;
import jakarta.validation.Valid;

/**
 * Controller class handling requests to the /product endpoint.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	private final GamesRepositoryInterface gamesRepository;

	/**
	 * Dependency injection through constructor.
	 * @param gamesRepository The repository used to retrieve game data.
	 */
	public ProductController(GamesRepositoryInterface gamesRepository) {
		this.gamesRepository = gamesRepository;
	}

	/**
	 * GET method returning page to create, edit, or delete new product.
	 * @param model Model's attributes are used to render the view.
	 * @return The name of HTML file for creating a new product (productCreation.html).
	 */
	@GetMapping("/create")
	public String productCreationDisplay(Model model) {
		model.addAttribute("product", new ProductModel());
		
		List<GameEntity> games = gamesRepository.findAll();
		model.addAttribute("games", games);
		
		return "products/productCreation";
	}

	/**
	 * POST method to create new product.
	 * @param productModel Product data submitted by the user.
	 * @param bindingResult Result of validation.
	 * @param model Model's attributes are used to render the view.
	 * @return The name of HTML file displaying success page (success.html).
	 */
	@PostMapping("/create")
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

	/**
	 * GET method returning the page to edit product.
	 * @param id Product's id
	 * @param model Model's attributes are used to render the view.
	 * @return The name of HTML file for editing the product (productEdit.html).
	 */
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Long id, Model model) {
		Optional<GameEntity> game = gamesRepository.findById(id);
		if (game.isPresent()) {
			model.addAttribute("game", game.get());
			return "products/productEdit";
		} else
			throw new IllegalArgumentException("Invalid product ID: " + id);
	}
	
	/**
	 * POST method updating an existing product.
	 * @param game Updated product's details submitted from the form.
	 * @param bindingResult Captures validation errors.
	 * @return Edit page if validation fails. If successful, redirects to product creation page.
	 */
	@PostMapping("/update")
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
	
	/**
	 * POST method removing the existing product.
	 * @param id Product's id.
	 * @return Redirects to product creation page.
	 */
	@PostMapping("/delete/{id}")
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

	/**
	 * GET method displaying product details.
	 * @param id Product's id
	 * @param model Model's attributes are used to render the view.
	 * @return Name of HTML file displaying product details (productDetails.html). 
	 */
	@GetMapping("/details/{id}")
	public String productDetails(@PathVariable Long id, Model model) {
		Optional<GameEntity> game = gamesRepository.findById(id);
		if (game.isPresent()) {
			model.addAttribute("game", game.get());
			return "products/productDetails";
		} else
			throw new IllegalArgumentException("Invalid product ID: " + id);
	}
}

/**
 * RestController class responsible for REST APIs.
 */
@RestController
@RequestMapping("/api/product")
class ProductApiController {

    private final GamesRepositoryInterface gamesRepository;

    /**
     * Dependency injection through constructor.
     * @param gamesRepository The repository used to retrieve game data.
     */
    public ProductApiController(GamesRepositoryInterface gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    /**
     * REST API displaying all products in JSON format.
     * @return All products from the repository.
     */
    @GetMapping
    public List<GameEntity> getAllProducts() {
        return gamesRepository.findAll();
    }

    /**
     * REST API displaying desired product by id.
     * @param id Product's id.
     * @return Product with specific id from the repository.
     */
    @GetMapping("/{id}")
    public GameEntity getProductById(@PathVariable Long id) {
        return gamesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
    }
}