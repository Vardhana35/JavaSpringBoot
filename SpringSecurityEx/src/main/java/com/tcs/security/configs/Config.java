package com.tcs.security.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//bean classes are written in config class

@Configuration
public class Config {

	// UserDetailsService is an interface which holds user's data
	// internally spring security uses object to validate username and password

	/*@Bean
	protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();

		users.add(User.withDefaultPasswordEncoder().username("abc").password("xyz").roles("user").build());

		users.add(User.withDefaultPasswordEncoder().username("abc2").password("xyz2").roles("user").build());

		users.add(User.withDefaultPasswordEncoder().username("xyz").password("xyz").roles("admin").build());

		return new InMemoryUserDetailsManager(users);
	}*/

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public DaoAuthenticationProvider authenticate() {
		DaoAuthenticationProvider dp = new DaoAuthenticationProvider(userDetailsService);
		dp.setPasswordEncoder(new BcryptPassword4jPasswordEncoder());
		return dp;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(auth->auth
		    .requestMatchers("/login","/wel","/WEB-INF/**").permitAll()
		    .anyRequest().authenticated()
		    )
		    .formLogin(form->form
			.loginPage("/login")
			.loginProcessingUrl("/login")
			.permitAll()
		    .defaultSuccessUrl("/sam",true)
		    )
		    .logout(logout->logout
			.permitAll()
			);
		return http.build();		   
	}
}
