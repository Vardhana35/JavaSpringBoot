package com.tcs.nbp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.nbp.beans.Account;
import com.tcs.nbp.services.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
    private AccountService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAccount(@Valid @RequestBody Account account) {
        service.create(account);
        return "Account has been saved";
    }
    
    @GetMapping
    public List<Account> getAllAccounts(){
    	return service.getAll();
    }

    @GetMapping("/{accNum}")
    public Account getAccount(@PathVariable Integer accNum) {
        return service.get(accNum);
    }

    @GetMapping("/branch/{branchId}")
    public List<Account> getAccountsByBranchId(@PathVariable String branchId) {
        return service.getByBranchId(branchId);
    }

    @PutMapping("/{accNum}")
    public String updateAccount(@PathVariable Integer accNum) {
        service.update(accNum);
        return "Account has been updated";
    }

    @DeleteMapping("/{accNum}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Integer accNum) {
        service.delete(accNum);
    }
}

