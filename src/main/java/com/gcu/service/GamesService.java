package com.gcu.service;

import org.springframework.stereotype.Service;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepositoryInterface;

@Service
public class GamesService {
	
	private final GamesRepositoryInterface gamesRepositoryInterface;
	
	public GamesService(GamesRepositoryInterface gamesRepositoryInterface) {
		this.gamesRepositoryInterface = gamesRepositoryInterface;
	}
	
	public void addGame(GameEntity game) {
		gamesRepositoryInterface.save(game);
	}

}
