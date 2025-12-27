package com.tcs.vms.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.tcs.vms.bean.Vehicle;
import com.tcs.vms.repo.VehicleRepo;

import jakarta.validation.Valid;

@Service
@Validated
public class VehicleService {

	@Autowired
	private VehicleRepo repo;

	@Transactional
	public void saveVehicle(@Valid Vehicle v) { 
		//v.setVehicleId(UUID.randomUUID().toString().substring(0,6));
		repo.save(v);
	}
	
	public List<Vehicle> getAllVehicles() {
		return repo.findAll();
	}

	public Vehicle getByVehicleId(String vehicleId) {
		/*Optional<Vehicle> veh=repo.findById(vehicleId);
		if (veh.isPresent())
			return veh.get();
        else
        	throw new RuntimeException("vehicle doesn't exists with vehicleId: " + vehicleId);*/
		return repo.findById(vehicleId)
				.orElseThrow(() -> new RuntimeException("Vehicle doesn't exists with vehicleId: " + vehicleId));	}
	
	public List<Vehicle> getByownerName(String ownerName){
		return Optional.of(repo.findByownerName(ownerName)).filter(list->!list.isEmpty())
				.orElseThrow(()->new RuntimeException("Vehicle doesn't exists with ownerName: " + ownerName));
	}
}
