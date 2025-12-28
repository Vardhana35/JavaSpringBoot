package com.tcs.spring.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tcs.spring.jpa.beans.Employee;
import com.tcs.spring.jpa.beans.PfBankDetails;
import com.tcs.spring.jpa.repo.EmployeeRepo;

import jakarta.validation.Valid;

@Service
public class EmpService {

	@Autowired
	private EmployeeRepo repo;

	public void saveEmp(@Valid Employee obj) {
		repo.save(obj);
	}

	public Employee getEmployee(int empno) {
		return repo.getReferenceById(empno);
	}

	public List<Employee> getAllEmp() {
		return repo.findAll();
	}

	public List<Employee> getByName(String ename) {
		return repo.findByEname(ename);
	}

	public List<Employee> getByEmail(String email) {
		return repo.findByEmail(email);
	}

	public List<Employee> getByEmailOrEname(String ename, String email) {
		return repo.findByEnameOrEmail(ename, email);
	}

	public List<Employee> getEmpBySort() {
		return repo.getEmpBySort();
	}

	public List<Employee> getEmpBySort(int sal) {
		return repo.getEmpBySort(sal);
	}
	
	public List<Employee> getEmployeesPage(int pageNumber,int pageSize){
		Pageable p= PageRequest.of(pageNumber, pageSize);
		return repo.findAll(p).toList();
	}
	
	public List<PfBankDetails> getByPfno(String pfno){
		return repo.findByPfno(pfno);
	}

}
