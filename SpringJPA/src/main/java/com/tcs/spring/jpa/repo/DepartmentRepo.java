package com.tcs.spring.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.spring.jpa.beans.Department;

public interface DepartmentRepo extends JpaRepository<Department, String> {

}
