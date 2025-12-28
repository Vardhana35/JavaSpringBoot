package com.tcs.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.spring.jpa.beans.PfBankDetails;
import com.tcs.spring.jpa.service.EmpService;
import com.tcs.spring.jpa.service.PfService;

@RestController
public class PfController {

	@Autowired
	private EmpService service;
	
	@Autowired
	private PfService ser;
	
	@GetMapping("/getpfdetails/{empno}")
	public ResponseEntity<PfBankDetails> getPfDetailsbyEmpno(@PathVariable int empno){
		return new ResponseEntity(service.getEmployee(empno),HttpStatus.OK);
	}
	
	@GetMapping("/getpf/{pfno}")
	public ResponseEntity<PfBankDetails> getPfDetailsByPfno(@PathVariable String pfno){
		return new ResponseEntity<>(ser.getPfDetails(pfno),HttpStatus.OK);
	}
	
	@GetMapping("/getallpf")
	public ResponseEntity<PfBankDetails> getPfDetails(){
		return new ResponseEntity(ser.getAllPfDetails(),HttpStatus.OK);
	}
	
}
