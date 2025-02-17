package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
public class MilestoneApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MilestoneApplication.class, args);
	}

}
