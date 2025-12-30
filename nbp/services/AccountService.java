package com.tcs.nbp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.nbp.beans.Account;
import com.tcs.nbp.repos.AccountRepo;

@Service
public class AccountService {
	
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
    
    public List<Account> getAll(){
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
}

