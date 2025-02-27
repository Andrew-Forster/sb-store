package com.gcu.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.UserEntity;

/**
 * Repository interface managing user entities
 */
public interface UserRepositoryInterface extends CrudRepository<UserEntity, Long>  {
	
	/**
	 * Method retrieving user entity by username
	 * @param username User's username
	 * @return User entity
	 */
	Optional<UserEntity> findByUsername(String username);
    	
	/**
	 * Method retrieving the list of all user entities
	 */
	@Override
	@Query(value="SELECT * FROM USERS")
	public List<UserEntity> findAll();

    /**
     * Method checking if email is already registered in the database.
     * @param email User's email
     * @return Number of users with given email. If the value is greater than 0, email is already in use.
     */
	@Query(value = "select Count(*) as count from USERS where email = :email")
    public int validEmail(String email);

    /**
     * Method checking if username is already registered in the database.
     * @param username User's username
     * @return Number of users with given username. If the value is greater than 0, username is already taken. 
     */
	@Query(value = "select Count(*) as count from USERS where username = :username")
    public int validUsername(String username);
}
