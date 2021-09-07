package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.model.Monitor;

public interface MonitorDao extends JpaRepository<Monitor, Integer> {
	
	@Query("SELECT DISTINCT m.manufacturer from Monitor m")
	List<String> getAllbyMonitorManufacturer();
	
	@Query("SELECT DISTINCT m.manufacturer from Monitor m where m.status = 'Available'")
	List<String> getAvailablebyMonitorManufacturer();
	
	@Query("SELECT DISTINCT m.monitorModel from Monitor m where m.manufacturer= :mfg")
	List<String> findAllByManufacturer(String mfg);
	
	@Query("SELECT DISTINCT m.monitorModel from Monitor m where m.manufacturer= :mfg and m.status = 'Available'")
	List<String> findAvailableByManufacturer(String mfg);

	@Query("SELECT DISTINCT m.serialNo from Monitor m where m.monitorModel= :model")
	List<String> findSerialNoByModel(String model);
	
	@Query("SELECT m from Monitor m WHERE m.serialNo= :serialno and m.status = 'Available'")
	List<Monitor> findAvailableBySerialNo(String serialno);
	
	@Query("SELECT m from Monitor m WHERE m.serialNo= :serialno")
	List<Monitor> findAllBySerialNo(String serialno);
}
