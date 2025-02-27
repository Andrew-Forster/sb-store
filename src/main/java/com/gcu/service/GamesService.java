package com.gcu.service;

import org.springframework.stereotype.Service;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepositoryInterface;

/**
 * Service class responsible for game-reltaed business logic
 */
@Service
public class GamesService {
	
	private final GamesRepositoryInterface gamesRepositoryInterface;
	
	/**
	 * Dependency injection through constructor
	 * @param gamesRepositoryInterface Repository interface performing CRUD operations on GameEntity
	 */
	public GamesService(GamesRepositoryInterface gamesRepositoryInterface) {
		this.gamesRepositoryInterface = gamesRepositoryInterface;
	}
	
	/**
	 * Method adding new game to the repository
	 * @param game GameEntity object to be saved in the database
	 */
	public void addGame(GameEntity game) {
		gamesRepositoryInterface.save(game);
	}

}
