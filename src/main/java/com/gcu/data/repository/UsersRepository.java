package com.gcu.data.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository {
    
    private final JdbcTemplate jdbcTemplate;
	
	public UsersRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    public void resetId() {
		
		String resetSql = "ALTER TABLE USERS AUTO_INCREMENT = 1";
		jdbcTemplate.execute(resetSql);
	}
}
