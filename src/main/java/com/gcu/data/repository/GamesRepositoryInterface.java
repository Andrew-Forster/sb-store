package com.gcu.data.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.GameEntity;
public interface GamesRepositoryInterface extends CrudRepository<GameEntity, Long> {
	
	@Override
	@Query("SELECT * FROM GAMES")
	public List<GameEntity> findAll();

	@Override
	@Query("SELECT * FROM GAMES WHERE id = :id")
	public Optional<GameEntity> findById(Long id);
}