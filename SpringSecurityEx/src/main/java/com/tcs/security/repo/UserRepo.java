package com.tcs.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.security.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
	User findByUsername(String username);
}
