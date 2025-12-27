package com.tcs.springvalidation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springvalidation.bean.Operation;

import jakarta.validation.Valid;

@RestController
public class OperationController {

	public OperationController() {

	}

	@PostMapping("/getsum")
	public ResponseEntity<Integer> sum(@Valid @RequestBody Operation ope) {
		validateInputValues(ope);
		ope.setResult(ope.getInput1() + ope.getInput2());
		return new ResponseEntity<>(ope.getResult(), HttpStatus.OK);
	}

	@PostMapping("/getdiv")
	public ResponseEntity<Integer> div(@Valid @RequestBody Operation ope) {
		validateInputValues(ope);
		ope.setResult(ope.getInput1() / ope.getInput2());
		return new ResponseEntity<>(ope.getResult(), HttpStatus.OK);
	}

	public void validateInputValues(Operation ope) {
		if (ope.getInput1() == 0 && ope.getInput2() == 0) {
			throw new NumberFormatException("zero values");
		}
	}
}
