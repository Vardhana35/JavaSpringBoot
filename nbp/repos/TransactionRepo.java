package com.tcs.nbp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.nbp.beans.TransactionHistory;

public interface TransactionRepo extends JpaRepository<TransactionHistory, String> {
	List<TransactionHistory> findByAccNum(Integer accNum);
}
