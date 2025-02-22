package com.gcu.data.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository {
    
    private final JdbcTemplate jdbcTemplate;
	
	public UsersRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
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
