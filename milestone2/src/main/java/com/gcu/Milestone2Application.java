package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gcu"})
public class Milestone2Application {

	public static void main(String[] args) {
		SpringApplication.run(Milestone2Application.class, args);
	}

}
