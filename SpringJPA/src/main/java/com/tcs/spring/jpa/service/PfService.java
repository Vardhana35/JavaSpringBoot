package com.tcs.spring.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.spring.jpa.beans.PfBankDetails;
import com.tcs.spring.jpa.repo.PfRepo;

@Service
public class PfService {

	@Autowired
	private PfRepo repo;
	
	public PfBankDetails getPfDetails(String pfno) {
		return repo.getByPfno(pfno);
	}
	
	public List<PfBankDetails> getAllPfDetails(){
		return repo.findAll();
	}
}
