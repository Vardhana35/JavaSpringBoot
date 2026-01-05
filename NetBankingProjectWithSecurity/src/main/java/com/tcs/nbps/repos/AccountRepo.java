package com.tcs.nbps.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.nbps.beans.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    List<Account> findByBranchId(String branchId);

	Account findByUsername(String username);
}

