package com.tcs.spring.jpa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.spring.jpa.beans.Department;
import com.tcs.spring.jpa.repo.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo repo;

	public List<Department> getAllDepartments() {
		return repo.findAll();
	}

	public Optional<Department> getDepartmentById(String deptno) {
		return repo.findById(deptno);
	}

	public Department saveDepartment(Department department) {

		String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
		department.setDeptno(uuid);
		return repo.save(department);
	}

	public Department updateDepartment(String deptno, Department department) {
		return repo.findById(deptno).map(existing -> {
			existing.setDname(department.getDname());
			existing.setLoc(department.getLoc());
			existing.setCapaicty(department.getCapaicty());
			return repo.save(existing);
		}).orElseThrow(() -> new RuntimeException("Department not found"));
	}

	public void deleteDepartment(String deptno) {
		repo.deleteById(deptno);
	}
}
