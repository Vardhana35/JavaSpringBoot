package com.tcs.ass_s2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ass_s2.beans.Project;
import com.tcs.ass_s2.services.ProjectService;

import jakarta.validation.Valid;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@PostMapping("/saveproject")
	public ResponseEntity<String> savePro(@Valid @RequestBody Project p){
		service.saveProject(p);
		return new ResponseEntity<>("Project has been saved",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Project>> getallProjects(){
		return new ResponseEntity<>(service.getAllProjects(),HttpStatus.OK);
	}
	
	@GetMapping("/getbyId")
	public ResponseEntity<Project> getProjectById(@RequestParam String projectId){
		return new ResponseEntity<>(service.getByprojectId(projectId),HttpStatus.OK);
	}
	
	@GetMapping("/getbyclientName")
	public ResponseEntity<List<Project>> getProjectByClient(@RequestParam String clientName){
		return new ResponseEntity<>(service.getByclientName(clientName),HttpStatus.OK);
	}
}
