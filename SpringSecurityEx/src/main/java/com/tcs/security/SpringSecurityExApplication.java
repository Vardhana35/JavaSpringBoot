package com.tcs.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;

@SpringBootApplication
public class SpringSecurityExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExApplication.class, args);
		
	}

}
