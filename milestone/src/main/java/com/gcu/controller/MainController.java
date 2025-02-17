package com.gcu.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepositoryInterface;
import com.gcu.model.ProductModel;

@Controller
public class MainController {

	private final GamesRepositoryInterface gamesRepository;

	public MainController(GamesRepositoryInterface gamesRepository) {
		this.gamesRepository = gamesRepository;
	}

	@GetMapping({ "/", "/main", "/home" })
	public String showTitle(Model model) {
		model.addAttribute("game", new ProductModel());
		List<GameEntity> availableGames = gamesRepository.findAll();
		model.addAttribute("availableGames", availableGames);
		return "mainPage";
	}
}
