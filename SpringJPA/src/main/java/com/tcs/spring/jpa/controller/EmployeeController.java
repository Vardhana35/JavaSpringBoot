package com.tcs.spring.jpa.controller;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.spring.jpa.beans.Employee;
import com.tcs.spring.jpa.beans.PfBankDetails;
import com.tcs.spring.jpa.service.EmpService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	private Map<Integer, Employee> map;

	@Autowired
	private EmpService service;

	public EmployeeController() {
		map = new HashMap<>();
	}

	@PostMapping("/saveemp")
	public ResponseEntity<String> saveEmp(@Valid @RequestBody Employee obj) {
		/*
		 * Employee emp=null; System.out.println(emp.getEmail());
		 * 
		 * map.put(obj.getEmpno(), obj);
		 */
		service.saveEmp(obj);
		return new ResponseEntity<>("Employee obj has been saved", HttpStatus.OK);
	}

	@RequestMapping("/getallemps")
	public ResponseEntity<List<Employee>> getAllEmps() {
		List<Employee> list = service.getAllEmp();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping("/getemp/{empno}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int empno) {
		if (empno < 0) {
			throw new NullPointerException("-ve value inserted");
		}
		Employee emp = service.getEmployee(empno);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@RequestMapping("/getbyename")
	public ResponseEntity<Employee> getName(@RequestParam String ename) {
		List<Employee> l = service.getByName(ename);
		return new ResponseEntity(l, HttpStatus.OK);
	}

	@RequestMapping("/getbymail")
	public ResponseEntity<Employee> getEmail(@RequestParam String email) {
		List<Employee> l = service.getByEmail(email);
		return new ResponseEntity(l, HttpStatus.OK);
	}

	@RequestMapping("/getbynameormail")
	public ResponseEntity<Employee> getEmailOrEname(@RequestParam(required = false) String ename,
			@RequestParam(required = false) String email) {
		List<Employee> l = service.getByEmailOrEname(ename, email);
		return new ResponseEntity(l, HttpStatus.OK);
	}

	@RequestMapping("/getempbysort")
	public ResponseEntity<Employee> getEmpbySort() {
		List<Employee> l = service.getEmpBySort();
		return new ResponseEntity(l, HttpStatus.OK);
	}

	@RequestMapping("/getempbysort1")
	public ResponseEntity<Employee> getEmpbySort(@RequestParam int sal) {
		List<Employee> l = service.getEmpBySort(sal);
		return new ResponseEntity(l, HttpStatus.OK);
	}
	
	@GetMapping("/getallemps/{pageNumber}/{pageSize}")
	public ResponseEntity<List<Employee>> getEmployeeOnPagination(@PathVariable int pageNumber,@PathVariable int pageSize){
		return new ResponseEntity<>(service.getEmployeesPage(pageNumber, pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/getbypfno")
	public ResponseEntity<List<PfBankDetails>> getbypfno(@RequestParam String pfno){
		return new ResponseEntity<>(service.getByPfno(pfno),HttpStatus.OK);
	}

}
