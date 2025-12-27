package com.tcs.ass_s2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ass_s2.beans.Project;
import com.tcs.ass_s2.repos.ProjectRepo;

import jakarta.validation.Valid;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepo repo;

	public void saveProject(@Valid Project p) {
		if (p.equals(null)) {
			throw new NullPointerException("project does not contain any data");
		}
		repo.save(p);
	}

	public List<Project> getAllProjects() {
		return repo.findAll();
	}

	public Project getByprojectId(String projectId) {
		/*if (repo.existsById(projectId))
			return repo.findById(projectId);
	    else
	    	throw new RuntimeException("Project doesn't exists with projectId: " + projectId);*/
		
		return repo.findById(projectId)
				.orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));
	}

	public List<Project> getByclientName(String clientName) {
		return Optional.ofNullable(repo.findByClientName(clientName))
		        .filter(list -> !list.isEmpty())
		        .orElseThrow(() -> new RuntimeException("Project not found with clientName: " + clientName));
		
		/*if (repo.existsByClientName(clientName))
			return repo.findByClientName(clientName);
		else
			throw new RuntimeException("Project not found with clientName: " + clientName);*/
	}
}
