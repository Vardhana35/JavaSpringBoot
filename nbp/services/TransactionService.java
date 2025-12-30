package com.tcs.nbp.services;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tcs.nbp.beans.Account;
import com.tcs.nbp.beans.TransactionHistory;
import com.tcs.nbp.repos.TransactionRepo;

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

	public TransactionHistory update(TransactionHistory th) {
		return repo.save(th);
	}
	
	/*public TransactionHistory updateById(String transactionId,TransactionHistory th) {
		TransactionHistory existing=get(transactionId);
		return repo.save(existing);
	}*/

	public void delete(String transactionId) {
		if (!repo.existsById(transactionId)) {
			throw new RuntimeException("Transaction not found: " + transactionId);
		}
		repo.deleteById(transactionId);
	}
}
