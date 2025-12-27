package com.tcs.vms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.vms.bean.Vehicle;


@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, String> {

	public List<Vehicle> findByownerName(String ownerName);

	
}
