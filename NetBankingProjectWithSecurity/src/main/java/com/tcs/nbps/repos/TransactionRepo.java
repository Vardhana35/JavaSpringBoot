package com.tcs.nbps.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.nbps.beans.TransactionHistory;

public interface TransactionRepo extends JpaRepository<TransactionHistory, String> {
	List<TransactionHistory> findByAccNum(Integer accNum);
}
