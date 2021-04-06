package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonElement;
import com.project.model.Machine;
@Repository
public interface MachineDao extends JpaRepository<Machine, Integer> {
	
	@Query("SELECT DISTINCT m.manufacture from Machine m where m.status = 'Available'")
	List<String> getbyMachineManufacture();
	
	@Query("SELECT DISTINCT m.machinemodel from Machine m where m.manufacture= :mfg and m.status = 'Available'")
	List<String> findByManufacture(String mfg);

	@Query("SELECT DISTINCT m.serialno from Machine m where m.machinemodel= :model and m.status = 'Available'")
	List<String> findSerialNoByModel(String model);
	
	
	@Query("SELECT m from Machine m WHERE m.serialno= :serialno and m.status = 'Available' ")
	List<Machine> findBySerialNo(String serialno);
	
	//"SELECT u FROM User u WHERE u.username= :uname and u.password= :password "

}
