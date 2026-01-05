package com.tcs.nbps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcs.nbps.beans.Account;
import com.tcs.nbps.repos.AccountRepo;

@Service
public class AccountService implements UserDetailsService {

	@Autowired
	private AccountRepo repo;

	public Account create(Account account) {
		return repo.save(account);
	}

	public Account get(Integer accNum) {
		return repo.getReferenceById(accNum);
	}

	public List<Account> getByBranchId(String branchId) {
		return repo.findByBranchId(branchId);
	}

	public List<Account> getAll() {
		return repo.findAll();
	}

	public void update(Integer accNum) {
		Account existing = get(accNum);
		repo.save(existing);
	}

	public void delete(Integer accNum) {
		if (!repo.existsById(accNum)) {
			throw new RuntimeException("Account not found: " + accNum);
		}
		repo.deleteById(accNum);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = repo.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		} // Adapt Account into Spring Security UserDetails
		return org.springframework.security.core.userdetails.User.withUsername(account.getUsername())
				.password(account.getPassword())
				// must be BCrypt encoded
				.roles("USER") // or fetch role if you store it
				.build();
	}
}
