package com.tcs.security.service;

import org.springframework.stereotype.Service;

import com.tcs.security.entity.User;
import com.tcs.security.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username){
    	User user = userRepo.findByUsername(username); 
    	if (user == null) { 
    		throw new UsernameNotFoundException("User not found: " + username); 
    		} 
    	return user;
    }
}

