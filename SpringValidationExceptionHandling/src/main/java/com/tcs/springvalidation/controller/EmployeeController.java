package com.tcs.springvalidation.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springvalidation.bean.Employee;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	private Map<Integer, Employee> map;

	public EmployeeController() {
		map = new HashMap<>();
	}

	@PostMapping("/saveemp")
	public ResponseEntity<String> saveEmp(@Valid @RequestBody Employee obj) {
		/*
		 * Employee emp=null; System.out.println(emp.getEmail());
		 */
		map.put(obj.getEmpno(), obj);
		return new ResponseEntity<>("Employee obj has been saved", HttpStatus.OK);
	}

	@RequestMapping("/getallemps")
	public ResponseEntity<List<Employee>> getAllEmps() {
		return new ResponseEntity<>(new ArrayList<>(map.values()), HttpStatus.OK);
	}

	@RequestMapping("/getemp/{empno}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int empno) {
		if (empno < 0) {
			throw new NullPointerException("-ve value inserted");
		}
		return new ResponseEntity<>(map.get(empno), HttpStatus.OK);
	}

	@RequestMapping("/getemployee")
	public ResponseEntity<Employee> getEmployee2(@RequestParam int empno) {
		return new ResponseEntity(map.get(empno), HttpStatus.OK);
	}

}
