package com.gcu.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.gcu.data.entity.UserEntity;

public interface UserRepositoryInterface extends CrudRepository<UserEntity, Long>  {
	
	Optional<UserEntity> findByUsername(String username);
    	
	@Override
	@Query(value="SELECT * FROM USERS")
	public List<UserEntity> findAll();

    @Query(value = "select Count(*) as count from USERS where email = :email")
    public int validEmail(String email);

    @Query(value = "select Count(*) as count from USERS where username = :username")
    public int validUsername(String username);
}
