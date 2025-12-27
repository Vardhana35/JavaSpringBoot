package com.tcs.vms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.vms.bean.Vehicle;
import com.tcs.vms.service.VehicleService;

import jakarta.validation.Valid;

@RestController
public class VehicleController {

	@Autowired
	private VehicleService service;
	
	@PostMapping("/savevehicle")
	public ResponseEntity<String> saveVeh(@Valid @RequestBody Vehicle v){
		service.saveVehicle(v);
		return new ResponseEntity<>("Vehicle object has been saved",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getbyId")
	public ResponseEntity<Vehicle> getVehiclebyId(@RequestParam String vehicleId) {
		return new ResponseEntity<>(service.getByVehicleId(vehicleId),HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Vehicle>> getVehicles() {
		return new ResponseEntity<>(service.getAllVehicles(),HttpStatus.OK);
	}
	
	@GetMapping("/getbyName")
	public ResponseEntity<List<Vehicle>> getVehiclebyName(@RequestParam String ownerName) {
		return new ResponseEntity<>(service.getByownerName(ownerName),HttpStatus.OK);
	}
}
