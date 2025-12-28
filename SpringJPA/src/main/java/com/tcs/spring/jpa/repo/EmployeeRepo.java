package com.tcs.spring.jpa.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcs.spring.jpa.beans.Employee;
import com.tcs.spring.jpa.beans.PfBankDetails;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public List<Employee> findByEname(String ename);

	public List<Employee> findByEmail(String email);

	public List<Employee> findByEnameOrEmail(String ename, String email);

	@Query("select e from Employee e order by e.ename")
	public List<Employee> getEmpBySort();

	@Query("select e from Employee e where e.sal=:sal order by e.ename")
	public List<Employee> getEmpBySort(int sal);
	
	@Query(value = "select p.* from pf_bank_details p join employee e on p.empno = e.empno where p.pfno = :pfno", nativeQuery = true)
	public List<PfBankDetails> findByPfno(String pfno);

}
