package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.Machine;
@Repository
public interface MachineDao extends JpaRepository<Machine, Integer> {
	
	@Query("SELECT DISTINCT m.manufacturer from Machine m")
	List<String> getAllbyMachineManufacturer();
	
	@Query("SELECT DISTINCT m.manufacturer from Machine m where m.status = 'Available'")
	List<String> getAvailablebyMachineManufacturer();
	
	@Query("SELECT DISTINCT m.machineModel from Machine m where m.manufacturer= :mfg")
	List<String> findAllByManufacturer(String mfg);
	
	@Query("SELECT DISTINCT m.machineModel from Machine m where m.manufacturer= :mfg and m.status = 'Available'")
	List<String> findAvailableByManufacturer(String mfg);

	@Query("SELECT DISTINCT m.serialNo from Machine m where m.machineModel= :model")
	List<String> findSerialNoByModel(String model);
	
	@Query("SELECT m from Machine m WHERE m.serialNo= :serialno and m.status = 'Available'")
	List<Machine> findAvailableBySerialNo(String serialno);
	
	@Query("SELECT m from Machine m WHERE m.serialNo= :serialno")
	List<Machine> findAllBySerialNo(String serialno);
	
}
