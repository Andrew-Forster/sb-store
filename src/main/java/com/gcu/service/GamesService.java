package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepositoryInterface;

@Service
public class GamesService {
	
	@Autowired
	private GamesRepositoryInterface gamesRepositoryInterface;
	
	public void addGame(GameEntity game) {
		gamesRepositoryInterface.save(game);
	}

}
