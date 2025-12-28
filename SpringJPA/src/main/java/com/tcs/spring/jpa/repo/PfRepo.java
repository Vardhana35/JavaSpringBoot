package com.tcs.spring.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.spring.jpa.beans.PfBankDetails;

@Repository
public interface PfRepo extends JpaRepository<PfBankDetails, Integer> {

	public PfBankDetails getByPfno(String pfno);
}
