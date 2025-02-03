package com.gcu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.GameEntity;
import com.gcu.data.repository.GamesRepository;

@Service
public class GamesService {
	
	@Autowired
	private GamesRepository gamesRepository;
	
	public void addGame(GameEntity game) {
		gamesRepository.save(game);
	}

}
