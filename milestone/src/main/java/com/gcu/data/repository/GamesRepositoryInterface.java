package com.gcu.data.repository;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.GameEntity;
public interface GamesRepositoryInterface extends CrudRepository<GameEntity, Long> {
	
	@Override
	@Query("SELECT * FROM GAMES")
	public List<GameEntity> findAll();
}