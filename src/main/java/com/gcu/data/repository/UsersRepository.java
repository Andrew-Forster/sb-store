package com.gcu.data.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Repository class providing method for user authentication
 */
@Repository
public class UsersRepository {
    
    private final JdbcTemplate jdbcTemplate;
	
	/**
	 * Dependency injection through constructor
	 * @param jdbcTemplate jdbcTemplate used for executing SQL queries.
	 */
    public UsersRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    /**
     * Method authenticating registered user
     * @param username User's username
     * @param password User's password
     * @return true if credentials are valid, false if credentials don't match
     */
    public boolean authenticate(String username, String password) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        try {
            int count = jdbcTemplate.queryForObject(sql, new Object[]{username, password}, Integer.class);
            return count > 0;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
	
}
