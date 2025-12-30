package com.tcs.nbp.controllers;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.nbp.beans.TransactionHistory;
import com.tcs.nbp.services.TransactionService;

import jakarta.validation.constraints.Positive;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
    private TransactionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionHistory saveTransaction(@RequestBody TransactionHistory th) {
        return service.save(th);
    }
    
    @GetMapping
    public List<TransactionHistory> getAllAccounts(){
    	return service.getAll();
    }

    @GetMapping("/{transactionId}")
    public TransactionHistory getTransaction(@PathVariable String transactionId) {
        return service.get(transactionId);
    }

    @GetMapping("/account/{accNum}")
    public List<TransactionHistory> getByAccount(@PathVariable Integer accNum) {
        return service.listByAccount(accNum);
    }

    @PutMapping("/{transactionId}")
    public TransactionHistory updateTransaction(@RequestBody TransactionHistory th) {
        return service.update(th);
    }

    @DeleteMapping("/{transactionId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransaction(@PathVariable String transactionId) {
        service.delete(transactionId);
    }
}

