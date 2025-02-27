package com.gcu.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class with security settings
 */
@Configuration
public class SecurityConfig {

	/**
	 * Bean for password encoding
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Method defining authorization rules, form login, and logout functionality 
	 * @param http HttpSecurity configuring security settings for HTTP requests
	 * @return Configured SecurityFilterChain
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/login", "/register", "/css/**", "/fonts/**", "/images/**", "/js/**")
						.permitAll()
						.requestMatchers("/").hasAnyRole("CUSTOMER", "MANAGER", "EMPLOYEE")
						.requestMatchers("/product/create", "/product/edit", "/product/delete", 
										 "/product/update", "/api/**")
						.hasAnyRole("MANAGER", "EMPLOYEE")

						.anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/", true)
						.permitAll())
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login?logout")
						.permitAll());
		return http.build();
	}

}
