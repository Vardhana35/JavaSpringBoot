package com.tcs.nbp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.nbp.beans.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    List<Account> findByBranchId(String branchId);
}

