package com.tcs.nbps.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.nbps.beans.Account;
import com.tcs.nbps.beans.TransactionHistory;
import com.tcs.nbps.repos.TransactionRepo;

@Service
@Transactional
public class TransactionService {

	@Autowired
	private TransactionRepo repo;

	public TransactionHistory save(TransactionHistory th) {
		return repo.save(th);
	}
	
	public List<TransactionHistory> getAll(){
		return repo.findAll();
	}

	public List<TransactionHistory> listByAccount(Integer accNum) {
		return repo.findByAccNum(accNum);
	}

	public TransactionHistory get(String transactionId) {
		return repo.findById(transactionId)
				.orElseThrow(() -> new RuntimeException("Transaction not found: " + transactionId));
	}

	public void update(String transactionId) {
		TransactionHistory existing = get(transactionId);
        repo.save(existing);
	}

	public void delete(String transactionId) {
		if (!repo.existsById(transactionId)) {
			throw new RuntimeException("Transaction not found: " + transactionId);
		}
		repo.deleteById(transactionId);
	}
}
