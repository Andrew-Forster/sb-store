package com.gcu.data.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GamesRepository {
	
private final JdbcTemplate jdbcTemplate;
	
	public GamesRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void resetId() {
		
		String resetSql = "ALTER TABLE GAMES AUTO_INCREMENT = 1";
		jdbcTemplate.execute(resetSql);
	}

}
