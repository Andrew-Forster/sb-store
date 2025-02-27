package com.gcu.data.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.GameEntity;

/**
 * Repository interface managing game entities
 */
public interface GamesRepositoryInterface extends CrudRepository<GameEntity, Long> {
	
	/**
	 * Method retrieving all game entities from the database
	 */
	@Override
	@Query("SELECT * FROM GAMES")
	public List<GameEntity> findAll();

	/**
	 * Method retrieving game entity by its id
	 */
	@Override
	@Query("SELECT * FROM GAMES WHERE id = :id")
	public Optional<GameEntity> findById(Long id);
}