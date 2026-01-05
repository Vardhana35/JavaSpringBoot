package com.tcs.nbps.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.tcs.nbps.services.AccountService;

//bean classes are written in config class

@Configuration
public class Config {

	@Autowired
	private AccountService service;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticate() {
		DaoAuthenticationProvider dp = new DaoAuthenticationProvider(service);
		dp.setPasswordEncoder(passwordEncoder());
		return dp;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/login","/register", "/success","/WEB-INF/**")
				.permitAll().anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login")
						.loginProcessingUrl("/login")
						.permitAll()
						.defaultSuccessUrl("/hom", true))
				.logout(logout -> logout.permitAll());
		return http.build();
	}
}
