package com.tcs.ass_s2.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ass_s2.beans.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, String> {

	boolean existsByClientName(String clientName);
	
	public List<Project> findByClientName(String clientName);
	
}
